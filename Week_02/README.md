### 本周学习内容
- 哈希表，映射，集合
- 树，二叉树，二叉搜索树
- 堆，二叉堆，图（DFS,BFS）

### HashMap源码阅读笔记
- 最基本的构造方法
```java
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                loadFactor);
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}
```
解释：使用指定的初始化容量`initialCapacity` 和加载因子`loadFactor`构造一个空`HashMap`
`loadFactor`:HashMap的负加载因子，可计算出当前`table`长度下的扩容阈值：`threshold = loadFactor * table.length`,默认值为：`0.75f`
`threshold`:HashMap的扩容阈值，在HashMap中存储的Node键值对超过这个数量时，自动扩容容量为原来的二倍

- 添加元素方法

```java
    public V put(K key, V value) {
        // 倒数第二个参数false：表示允许旧值替换
        // 最后一个参数true：表示HashMap不处于创建模式
        return putVal(hash(key), key, value, false, true);
    }
```
解释：将指定参数key和指定参数value插入map中，如果key已经存在，那就替换key对应的value
#### put(K key, V value)可以分为三个步骤：
1. 通过hash(Object key)方法计算key的哈希值。
2. 通过putVal(hash(key), key, value, false, true)方法实现功能。
3. 返回putVal方法返回的结果。
### putVal(hash(key)
```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        //如果哈希表为空，调用resize()创建一个哈希表，并用变量n记录哈希表长度
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        /**
         * 如果指定参数hash在表中没有对应的桶，即为没有碰撞
         * Hash函数，(n - 1) & hash 计算key将被放置的槽位
         * (n - 1) & hash 本质上是hash % n，位运算更快
         */
        if ((p = tab[i = (n - 1) & hash]) == null)
            //直接将键值对插入到map中即可
            tab[i] = newNode(hash, key, value, null);
        else {// 桶中已经存在元素
            Node<K, V> e;
            K k;
            // 比较桶中第一个元素(数组中的结点)的hash值相等，key相等
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                // 将第一个元素赋值给e，用e来记录
                e = p;
                // 当前桶中无该键值对，且桶是红黑树结构，按照红黑树结构插入
            else if (p instanceof TreeNode)
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
                // 当前桶中无该键值对，且桶是链表结构，按照链表结构插入到尾部
            else {
                for (int binCount = 0; ; ++binCount) {
                    // 遍历到链表尾部
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 检查链表长度是否达到阈值，达到将该槽位节点组织形式转为红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 链表节点的<key, value>与put操作<key, value>相同时，不做重复操作，跳出循环
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            // 找到或新建一个key和hashCode与插入元素相等的键值对，进行put操作
            if (e != null) { // existing mapping for key
                // 记录e的value
                V oldValue = e.value;
                /**
                 * onlyIfAbsent为false或旧值为null时，允许替换旧值
                 * 否则无需替换
                 */
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                // 访问后回调
                afterNodeAccess(e);
                // 返回旧值
                return oldValue;
            }
        }
        // 更新结构化修改信息
        ++modCount;
        // 键值对数目超过阈值时，进行rehash
        if (++size > threshold)
            resize();
        // 插入后回调
        afterNodeInsertion(evict);
        return null;
    }
```
#### putVal方法可以分为下面的几个步骤:

1. 如果哈希表为空，调用resize()创建一个哈希表。
2. 如果指定参数hash在表中没有对应的桶，即为没有碰撞，直接将键值对插入到哈希表中即可。
3. 如果有碰撞，遍历桶，找到key映射的节点
  - 桶中的第一个节点就匹配了，将桶中的第一个节点记录起来。
  - 如果桶中的第一个节点没有匹配，且桶中结构为红黑树，则调用红黑树对应的方法插入键值对。
  - 如果不是红黑树，那么就肯定是链表。遍历链表，如果找到了key映射的节点，就记录这个节点，退出循环。如果没有找到，在链表尾部插入节点。插入后，如果链的长度大于等于TREEIFY_THRESHOLD这个临界值，则使用treeifyBin方法把链表转为红黑树。
4. 如果找到了key映射的节点，且节点不为null
  - 记录节点的vlaue
  - 如果参数onlyIfAbsent为false，或者oldValue为null，替换value，否则不替换。
  - 返回记录下来的节点的value。
5. 如果没有找到key映射的节点（2、3步中讲了，这种情况会插入到hashMap中），插入节点后size会加1，这时要检查size是否大于临界值threshold，如果大于会使用resize方法进行扩容。


### 本周练习题目
- [各位相加](https://leetcode-cn.com/problems/add-digits/)
- [二叉树遍历(前，中，后)](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [N叉树的遍历（前，后）](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
- [N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)
- [猜数字游戏](https://leetcode-cn.com/problems/bulls-and-cows/)
- [Fizz Buzz](https://leetcode-cn.com/problems/fizz-buzz/)
- [最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
- [两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)
- [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)
- [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
- [滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)
- [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)
- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [删除最外层的括号](https://leetcode-cn.com/problems/remove-outermost-parentheses/)
- [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)
- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)
