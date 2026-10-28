# Data-Structure
 Data Structures Problems and Examples

## 3. Comparison of Core Set Implementations

| Feature | HashSet | LinkedHashSet | TreeSet |
| --- | --- | --- | --- |
| Backing data structure | `HashMap` with an array and nodes | `LinkedHashMap` with an array and doubly linked nodes | `TreeMap` with a red-black tree |
| Average time complexity | `O(1)` for basic operations | `O(1)` for basic operations | `O(log n)` for basic operations |
| Element ordering | Unordered | Preserves insertion order | Sorted by natural order or a comparator |
| Duplicate detection | Uses `hashCode()` and `equals()` | Uses `hashCode()` and `equals()` | Uses `compareTo()` or a comparator |
| Null elements | Allows one `null` element | Allows one `null` element | Does not allow `null` with natural ordering |
