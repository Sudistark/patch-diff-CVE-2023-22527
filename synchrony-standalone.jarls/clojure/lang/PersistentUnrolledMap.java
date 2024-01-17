package clojure.lang;

import java.util.Iterator;
import java.util.Map;

public class PersistentUnrolledMap {
    static IPersistentMap EMPTY = new Card0();
    static Object NOT_FOUND = new Object();

    public static IPersistentMap create() {
        return EMPTY;
    }

    public static IPersistentMap create(Object k0, Object v0) {
        return new Card1(k0, v0, Util.hasheq(k0));
    }

    public static IPersistentMap create(Object k0, Object v0, Object k1,
            Object v1) {
        return new Card2(k0, v0, Util.hasheq(k0), k1, v1, Util.hasheq(k1));
    }

    public static IPersistentMap create(Object k0, Object v0, Object k1,
            Object v1, Object k2, Object v2) {
        return new Card3(k0, v0, Util.hasheq(k0), k1, v1, Util.hasheq(k1), k2,
                v2, Util.hasheq(k2));
    }

    public static IPersistentMap create(Object k0, Object v0, Object k1,
            Object v1, Object k2, Object v2, Object k3, Object v3) {
        return new Card4(k0, v0, Util.hasheq(k0), k1, v1, Util.hasheq(k1), k2,
                v2, Util.hasheq(k2), k3, v3, Util.hasheq(k3));
    }

    public static IPersistentMap create(Object k0, Object v0, Object k1,
            Object v1, Object k2, Object v2, Object k3, Object v3, Object k4,
            Object v4) {
        return new Card5(k0, v0, Util.hasheq(k0), k1, v1, Util.hasheq(k1), k2,
                v2, Util.hasheq(k2), k3, v3, Util.hasheq(k3), k4, v4,
                Util.hasheq(k4));
    }

    public static IPersistentMap create(Object k0, Object v0, Object k1,
            Object v1, Object k2, Object v2, Object k3, Object v3, Object k4,
            Object v4, Object k5, Object v5) {
        return new Card6(k0, v0, Util.hasheq(k0), k1, v1, Util.hasheq(k1), k2,
                v2, Util.hasheq(k2), k3, v3, Util.hasheq(k3), k4, v4,
                Util.hasheq(k4), k5, v5, Util.hasheq(k5));
    }

    static class Transient extends ATransientMap implements ITransientMap {
        private Object k0;
        private Object k1;
        private Object k2;
        private Object k3;
        private Object k4;
        private Object k5;
        private Object v0;
        private Object v1;
        private Object v2;
        private Object v3;
        private Object v4;
        private Object v5;
        private int h0;
        private int h1;
        private int h2;
        private int h3;
        private int h4;
        private int h5;
        private int count = 0;
        private boolean edit = true;

        public Transient() {
            count = 0;
        }

        public Transient(Object k0, Object v0, int h0) {
            count = 1;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
        }

        public Transient(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1) {
            count = 2;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
        }

        public Transient(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2) {
            count = 3;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
        }

        public Transient(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3) {
            count = 4;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
        }

        public Transient(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3, Object k4, Object v4, int h4) {
            count = 5;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
        }

        public Transient(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3, Object k4, Object v4, int h4, Object k5, Object v5,
                int h5) {
            count = 6;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
            this.k5 = k5;
            this.v5 = v5;
            this.h5 = h5;
        }

        void ensureEditable() {
            if (!edit) {
                throw new IllegalAccessError(
                        "Transient used after persistent! call");
            }
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                switch (6 - count) {
                case 0:
                    if (k5 == key) {
                        return 5;
                    }
                case 1:
                    if (k4 == key) {
                        return 4;
                    }
                case 2:
                    if (k3 == key) {
                        return 3;
                    }
                case 3:
                    if (k2 == key) {
                        return 2;
                    }
                case 4:
                    if (k1 == key) {
                        return 1;
                    }
                case 5:
                    if (k0 == key) {
                        return 0;
                    }
                default:
                    return -1;
                }
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            switch (6 - count) {
            case 0:
                if (h5 == h && ep.equiv(key, k5)) {
                    return 5;
                }
            case 1:
                if (h4 == h && ep.equiv(key, k4)) {
                    return 4;
                }
            case 2:
                if (h3 == h && ep.equiv(key, k3)) {
                    return 3;
                }
            case 3:
                if (h2 == h && ep.equiv(key, k2)) {
                    return 2;
                }
            case 4:
                if (h1 == h && ep.equiv(key, k1)) {
                    return 1;
                }
            case 5:
                if (h0 == h && ep.equiv(key, k0)) {
                    return 0;
                }
            }
            return -1;
        }

        ITransientMap doAssoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx == -1) {
                switch (count++) {
                case 0:
                    h0 = h;
                    k0 = key;
                    v0 = val;
                    return this;
                case 1:
                    h1 = h;
                    k1 = key;
                    v1 = val;
                    return this;
                case 2:
                    h2 = h;
                    k2 = key;
                    v2 = val;
                    return this;
                case 3:
                    h3 = h;
                    k3 = key;
                    v3 = val;
                    return this;
                case 4:
                    h4 = h;
                    k4 = key;
                    v4 = val;
                    return this;
                case 5:
                    h5 = h;
                    k5 = key;
                    v5 = val;
                    return this;
                default:
                    return PersistentHashMap.EMPTY.asTransient().assoc(k0, v0)
                            .assoc(k1, v1).assoc(k2, v2).assoc(k3, v3)
                            .assoc(k4, v4).assoc(k5, v5).assoc(key, val);
                }
            } else {
                switch (idx) {
                case 0:
                    v0 = val;
                    return this;
                case 1:
                    v1 = val;
                    return this;
                case 2:
                    v2 = val;
                    return this;
                case 3:
                    v3 = val;
                    return this;
                case 4:
                    v4 = val;
                    return this;
                case 5:
                    v5 = val;
                    return this;
                default:
                    return null;
                }
            }
        }

        Object doValAt(Object key, Object notFound) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            case 2:
                return v2;
            case 3:
                return v3;
            case 4:
                return v4;
            case 5:
                return v5;
            default:
                return notFound;
            }
        }

        ITransientMap doWithout(Object key) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx < 0) {
                return this;
            }
            count--;
            switch (idx) {
            case 0:
                k0 = k1;
                v0 = v1;
                h0 = h1;
                if (count == 1) {
                    break;
                }
            case 1:
                k1 = k2;
                v1 = v2;
                h1 = h2;
                if (count == 2) {
                    break;
                }
            case 2:
                k2 = k3;
                v2 = v3;
                h2 = h3;
                if (count == 3) {
                    break;
                }
            case 3:
                k3 = k4;
                v3 = v4;
                h3 = h4;
                if (count == 4) {
                    break;
                }
            case 4:
                k4 = k5;
                v4 = v5;
                h4 = h5;
            }
            return this;
        }

        IPersistentMap doPersistent() {
            switch (count) {
            case 0:
                return EMPTY;
            case 1:
                return new Card1(k0, v0, h0);
            case 2:
                return new Card2(k0, v0, h0, k1, v1, h1);
            case 3:
                return new Card3(k0, v0, h0, k1, v1, h1, k2, v2, h2);
            case 4:
                return new Card4(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3, h3);
            case 5:
                return new Card5(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                        h3, k4, v4, h4);
            case 6:
                return new Card6(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                        h3, k4, v4, h4, k5, v5, h5);
            }
            throw new IllegalStateException();
        }

        int doCount() {
            return count;
        }
    }

    public static class Card0 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        private final IPersistentMap meta;

        Card0(IPersistentMap meta) {
            this.meta = meta;
        }

        public Card0() {
            this.meta = null;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card0(meta);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            return -1;
        }

        public boolean containsKey(Object key) {
            return false;
        }

        public IMapEntry entryAt(Object key) {
            return null;
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            return notFound;
        }

        public ITransientMap asTransient() {
            return new Transient();
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            return new Card1(meta, key, val, h);
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            return new Card1(meta, key, val, h);
        }

        public IPersistentMap without(Object key) {
            return this;
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                _hasheq = Murmur3.mixCollHash(h, 0);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 0) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 0) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 0) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 0) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 0;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            return init;
        }

        public Object reduce(IFn f) {
            return f.invoke();
        }

        public Object reduce(IFn f, Object init) {
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return false;
                }

                public Object next() {
                    throw new IndexOutOfBoundsException();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] {};
        }

        public ISeq seq() {
            return null;
        }
    }

    public static class Card1 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object v0;
        final int h0;
        private final IPersistentMap meta;

        Card1(IPersistentMap meta, Object k0, Object v0, int h0) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
        }

        public Card1(Object k0, Object v0, int h0) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card1(meta, k0, v0, h0);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card1(meta, k0, val, h0);
            default:
                return new Card2(meta, k0, v0, h0, key, val, h);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            return new Card2(meta, k0, v0, h0, key, val, h);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card0(meta);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                _hasheq = Murmur3.mixCollHash(h, 1);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 1) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 1) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 1) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 1) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 1;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            return new MapEntry(k0, v0);
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 1;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 0) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 1 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }

    public static class Card2 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object k1;
        final Object v0;
        final Object v1;
        final int h0;
        final int h1;
        private final IPersistentMap meta;

        Card2(IPersistentMap meta, Object k0, Object v0, int h0, Object k1,
                Object v1, int h1) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
        }

        public Card2(Object k0, Object v0, int h0, Object k1, Object v1, int h1) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card2(meta, k0, v0, h0, k1, v1, h1);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                } else if (k1 == key) {
                    return 1;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            } else if (h1 == h && ep.equiv(key, k1)) {
                return 1;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            case 1:
                return new MapEntry(k1, v1);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0, k1, v1, h1);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card2(meta, k0, val, h0, k1, v1, h1);
            case 1:
                return new Card2(meta, k0, v0, h0, k1, val, h1);
            default:
                return new Card3(meta, k0, v0, h0, k1, v1, h1, key, val, h);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            return new Card3(meta, k0, v0, h0, k1, v1, h1, key, val, h);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card1(meta, k1, v1, h1);
            case 1:
                return new Card1(meta, k0, v0, h0);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                h += Util.hash(k1) ^ Util.hash(v1);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                h += Murmur3.mixCollHash(31 * (31 + h1) + Util.hasheq(v1), 2);
                _hasheq = Murmur3.mixCollHash(h, 2);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 2) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o1, v1)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 2) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equiv(v1, m.get(k1))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 2) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o1, v1)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 2) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equals(v1, m.get(k1))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 2;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k1, v1);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            Object init = k0;
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 2;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    case 1:
                        return new MapEntry(k1, v1);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0), new MapEntry(k1, v1) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                case 1:
                    return new MapEntry(k1, v1);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 1) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 2 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }

    public static class Card3 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object k1;
        final Object k2;
        final Object v0;
        final Object v1;
        final Object v2;
        final int h0;
        final int h1;
        final int h2;
        private final IPersistentMap meta;

        Card3(IPersistentMap meta, Object k0, Object v0, int h0, Object k1,
                Object v1, int h1, Object k2, Object v2, int h2) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
        }

        public Card3(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card3(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                } else if (k1 == key) {
                    return 1;
                } else if (k2 == key) {
                    return 2;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            } else if (h1 == h && ep.equiv(key, k1)) {
                return 1;
            } else if (h2 == h && ep.equiv(key, k2)) {
                return 2;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            case 1:
                return new MapEntry(k1, v1);
            case 2:
                return new MapEntry(k2, v2);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            case 2:
                return v2;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0, k1, v1, h1, k2, v2, h2);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card3(meta, k0, val, h0, k1, v1, h1, k2, v2, h2);
            case 1:
                return new Card3(meta, k0, v0, h0, k1, val, h1, k2, v2, h2);
            case 2:
                return new Card3(meta, k0, v0, h0, k1, v1, h1, k2, val, h2);
            default:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, key,
                        val, h);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, key,
                    val, h);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card2(meta, k1, v1, h1, k2, v2, h2);
            case 1:
                return new Card2(meta, k0, v0, h0, k2, v2, h2);
            case 2:
                return new Card2(meta, k0, v0, h0, k1, v1, h1);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                h += Util.hash(k1) ^ Util.hash(v1);
                h += Util.hash(k2) ^ Util.hash(v2);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                h += Murmur3.mixCollHash(31 * (31 + h1) + Util.hasheq(v1), 2);
                h += Murmur3.mixCollHash(31 * (31 + h2) + Util.hasheq(v2), 2);
                _hasheq = Murmur3.mixCollHash(h, 3);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 3) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o2, v2)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 3) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equiv(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equiv(v2, m.get(k2))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 3) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o2, v2)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 3) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equals(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equals(v2, m.get(k2))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 3;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k1, v1);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k2, v2);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            Object init = k0;
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 3;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    case 1:
                        return new MapEntry(k1, v1);
                    case 2:
                        return new MapEntry(k2, v2);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0), new MapEntry(k1, v1),
                    new MapEntry(k2, v2) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                case 1:
                    return new MapEntry(k1, v1);
                case 2:
                    return new MapEntry(k2, v2);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 2) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 3 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }

    public static class Card4 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object k1;
        final Object k2;
        final Object k3;
        final Object v0;
        final Object v1;
        final Object v2;
        final Object v3;
        final int h0;
        final int h1;
        final int h2;
        final int h3;
        private final IPersistentMap meta;

        Card4(IPersistentMap meta, Object k0, Object v0, int h0, Object k1,
                Object v1, int h1, Object k2, Object v2, int h2, Object k3,
                Object v3, int h3) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
        }

        public Card4(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                } else if (k1 == key) {
                    return 1;
                } else if (k2 == key) {
                    return 2;
                } else if (k3 == key) {
                    return 3;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            } else if (h1 == h && ep.equiv(key, k1)) {
                return 1;
            } else if (h2 == h && ep.equiv(key, k2)) {
                return 2;
            } else if (h3 == h && ep.equiv(key, k3)) {
                return 3;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            case 1:
                return new MapEntry(k1, v1);
            case 2:
                return new MapEntry(k2, v2);
            case 3:
                return new MapEntry(k3, v3);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            case 2:
                return v2;
            case 3:
                return v3;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3, h3);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card4(meta, k0, val, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3);
            case 1:
                return new Card4(meta, k0, v0, h0, k1, val, h1, k2, v2, h2, k3,
                        v3, h3);
            case 2:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, val, h2, k3,
                        v3, h3);
            case 3:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        val, h3);
            default:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, key, val, h);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, key, val, h);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card3(meta, k1, v1, h1, k2, v2, h2, k3, v3, h3);
            case 1:
                return new Card3(meta, k0, v0, h0, k2, v2, h2, k3, v3, h3);
            case 2:
                return new Card3(meta, k0, v0, h0, k1, v1, h1, k3, v3, h3);
            case 3:
                return new Card3(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                h += Util.hash(k1) ^ Util.hash(v1);
                h += Util.hash(k2) ^ Util.hash(v2);
                h += Util.hash(k3) ^ Util.hash(v3);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                h += Murmur3.mixCollHash(31 * (31 + h1) + Util.hasheq(v1), 2);
                h += Murmur3.mixCollHash(31 * (31 + h2) + Util.hasheq(v2), 2);
                h += Murmur3.mixCollHash(31 * (31 + h3) + Util.hasheq(v3), 2);
                _hasheq = Murmur3.mixCollHash(h, 4);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 4) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o3, v3)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 4) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equiv(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equiv(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equiv(v3, m.get(k3))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 4) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o3, v3)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 4) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equals(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equals(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equals(v3, m.get(k3))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 4;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k1, v1);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k2, v2);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k3, v3);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            Object init = k0;
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 4;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    case 1:
                        return new MapEntry(k1, v1);
                    case 2:
                        return new MapEntry(k2, v2);
                    case 3:
                        return new MapEntry(k3, v3);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0), new MapEntry(k1, v1),
                    new MapEntry(k2, v2), new MapEntry(k3, v3) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                case 1:
                    return new MapEntry(k1, v1);
                case 2:
                    return new MapEntry(k2, v2);
                case 3:
                    return new MapEntry(k3, v3);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 3) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 4 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }

    public static class Card5 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object k1;
        final Object k2;
        final Object k3;
        final Object k4;
        final Object v0;
        final Object v1;
        final Object v2;
        final Object v3;
        final Object v4;
        final int h0;
        final int h1;
        final int h2;
        final int h3;
        final int h4;
        private final IPersistentMap meta;

        Card5(IPersistentMap meta, Object k0, Object v0, int h0, Object k1,
                Object v1, int h1, Object k2, Object v2, int h2, Object k3,
                Object v3, int h3, Object k4, Object v4, int h4) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
        }

        public Card5(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3, Object k4, Object v4, int h4) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, k4, v4, h4);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                } else if (k1 == key) {
                    return 1;
                } else if (k2 == key) {
                    return 2;
                } else if (k3 == key) {
                    return 3;
                } else if (k4 == key) {
                    return 4;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            } else if (h1 == h && ep.equiv(key, k1)) {
                return 1;
            } else if (h2 == h && ep.equiv(key, k2)) {
                return 2;
            } else if (h3 == h && ep.equiv(key, k3)) {
                return 3;
            } else if (h4 == h && ep.equiv(key, k4)) {
                return 4;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            case 1:
                return new MapEntry(k1, v1);
            case 2:
                return new MapEntry(k2, v2);
            case 3:
                return new MapEntry(k3, v3);
            case 4:
                return new MapEntry(k4, v4);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            case 2:
                return v2;
            case 3:
                return v3;
            case 4:
                return v4;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, k4, v4, h4);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card5(meta, k0, val, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4);
            case 1:
                return new Card5(meta, k0, v0, h0, k1, val, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4);
            case 2:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, val, h2, k3,
                        v3, h3, k4, v4, h4);
            case 3:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        val, h3, k4, v4, h4);
            case 4:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, val, h4);
            default:
                return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4, key, val, h);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, k4, v4, h4, key, val, h);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card4(meta, k1, v1, h1, k2, v2, h2, k3, v3, h3, k4,
                        v4, h4);
            case 1:
                return new Card4(meta, k0, v0, h0, k2, v2, h2, k3, v3, h3, k4,
                        v4, h4);
            case 2:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k3, v3, h3, k4,
                        v4, h4);
            case 3:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k4,
                        v4, h4);
            case 4:
                return new Card4(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                h += Util.hash(k1) ^ Util.hash(v1);
                h += Util.hash(k2) ^ Util.hash(v2);
                h += Util.hash(k3) ^ Util.hash(v3);
                h += Util.hash(k4) ^ Util.hash(v4);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                h += Murmur3.mixCollHash(31 * (31 + h1) + Util.hasheq(v1), 2);
                h += Murmur3.mixCollHash(31 * (31 + h2) + Util.hasheq(v2), 2);
                h += Murmur3.mixCollHash(31 * (31 + h3) + Util.hasheq(v3), 2);
                h += Murmur3.mixCollHash(31 * (31 + h4) + Util.hasheq(v4), 2);
                _hasheq = Murmur3.mixCollHash(h, 5);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 5) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o3, v3)) {
                    return false;
                }
                Object o4 = m.valAt(k4, PersistentUnrolledMap.NOT_FOUND);
                if (o4 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o4, v4)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 5) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equiv(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equiv(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equiv(v3, m.get(k3))) {
                    return false;
                }
                boolean f4 = m.containsKey(k4);
                if (!f4 || !Util.equiv(v4, m.get(k4))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 5) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o3, v3)) {
                    return false;
                }
                Object o4 = m.valAt(k4, PersistentUnrolledMap.NOT_FOUND);
                if (o4 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o4, v4)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 5) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equals(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equals(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equals(v3, m.get(k3))) {
                    return false;
                }
                boolean f4 = m.containsKey(k4);
                if (!f4 || !Util.equals(v4, m.get(k4))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 5;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k1, v1);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k2, v2);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k3, v3);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k4, v4);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            Object init = k0;
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k4, v4));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k4, v4));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 5;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    case 1:
                        return new MapEntry(k1, v1);
                    case 2:
                        return new MapEntry(k2, v2);
                    case 3:
                        return new MapEntry(k3, v3);
                    case 4:
                        return new MapEntry(k4, v4);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0), new MapEntry(k1, v1),
                    new MapEntry(k2, v2), new MapEntry(k3, v3),
                    new MapEntry(k4, v4) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                case 1:
                    return new MapEntry(k1, v1);
                case 2:
                    return new MapEntry(k2, v2);
                case 3:
                    return new MapEntry(k3, v3);
                case 4:
                    return new MapEntry(k4, v4);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 4) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 5 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }

    public static class Card6 extends APersistentMap implements IObj,
            IEditableCollection, IReduce {
        final Object k0;
        final Object k1;
        final Object k2;
        final Object k3;
        final Object k4;
        final Object k5;
        final Object v0;
        final Object v1;
        final Object v2;
        final Object v3;
        final Object v4;
        final Object v5;
        final int h0;
        final int h1;
        final int h2;
        final int h3;
        final int h4;
        final int h5;
        private final IPersistentMap meta;

        Card6(IPersistentMap meta, Object k0, Object v0, int h0, Object k1,
                Object v1, int h1, Object k2, Object v2, int h2, Object k3,
                Object v3, int h3, Object k4, Object v4, int h4, Object k5,
                Object v5, int h5) {
            this.meta = meta;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
            this.k5 = k5;
            this.v5 = v5;
            this.h5 = h5;
        }

        public Card6(Object k0, Object v0, int h0, Object k1, Object v1,
                int h1, Object k2, Object v2, int h2, Object k3, Object v3,
                int h3, Object k4, Object v4, int h4, Object k5, Object v5,
                int h5) {
            this.meta = null;
            this.k0 = k0;
            this.v0 = v0;
            this.h0 = h0;
            this.k1 = k1;
            this.v1 = v1;
            this.h1 = h1;
            this.k2 = k2;
            this.v2 = v2;
            this.h2 = h2;
            this.k3 = k3;
            this.v3 = v3;
            this.h3 = h3;
            this.k4 = k4;
            this.v4 = v4;
            this.h4 = h4;
            this.k5 = k5;
            this.v5 = v5;
            this.h5 = h5;
        }

        public IPersistentMap meta() {
            return meta;
        }

        public IObj withMeta(IPersistentMap meta) {
            return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, k4, v4, h4, k5, v5, h5);
        }

        private int indexOf(int h, Object key) {
            if (key instanceof Keyword) {
                if (k0 == key) {
                    return 0;
                } else if (k1 == key) {
                    return 1;
                } else if (k2 == key) {
                    return 2;
                } else if (k3 == key) {
                    return 3;
                } else if (k4 == key) {
                    return 4;
                } else if (k5 == key) {
                    return 5;
                }
                return -1;
            }
            return indexOfObj(h, key);
        }

        private int indexOfObj(int h, Object key) {
            Util.EquivPred ep = Util.equivPred(key);
            if (h0 == h && ep.equiv(key, k0)) {
                return 0;
            } else if (h1 == h && ep.equiv(key, k1)) {
                return 1;
            } else if (h2 == h && ep.equiv(key, k2)) {
                return 2;
            } else if (h3 == h && ep.equiv(key, k3)) {
                return 3;
            } else if (h4 == h && ep.equiv(key, k4)) {
                return 4;
            } else if (h5 == h && ep.equiv(key, k5)) {
                return 5;
            }
            return -1;
        }

        public boolean containsKey(Object key) {
            return indexOf(Util.hasheq(key), key) >= 0;
        }

        public IMapEntry entryAt(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new MapEntry(k0, v0);
            case 1:
                return new MapEntry(k1, v1);
            case 2:
                return new MapEntry(k2, v2);
            case 3:
                return new MapEntry(k3, v3);
            case 4:
                return new MapEntry(k4, v4);
            case 5:
                return new MapEntry(k5, v5);
            default:
                return null;
            }
        }

        public Object valAt(Object key) {
            return valAt(key, null);
        }

        public Object valAt(Object key, Object notFound) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return v0;
            case 1:
                return v1;
            case 2:
                return v2;
            case 3:
                return v3;
            case 4:
                return v4;
            case 5:
                return v5;
            default:
                return notFound;
            }
        }

        public ITransientMap asTransient() {
            return new Transient(k0, v0, h0, k1, v1, h1, k2, v2, h2, k3, v3,
                    h3, k4, v4, h4, k5, v5, h5);
        }

        public IPersistentMap assoc(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            switch (idx) {
            case 0:
                return new Card6(meta, k0, val, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4, k5, v5, h5);
            case 1:
                return new Card6(meta, k0, v0, h0, k1, val, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4, k5, v5, h5);
            case 2:
                return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, val, h2, k3,
                        v3, h3, k4, v4, h4, k5, v5, h5);
            case 3:
                return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        val, h3, k4, v4, h4, k5, v5, h5);
            case 4:
                return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, val, h4, k5, v5, h5);
            case 5:
                return new Card6(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4, k5, val, h5);
            default:
                IPersistentMap map = PersistentHashMap.EMPTY.asTransient()
                        .assoc(k0, v0).assoc(k1, v1).assoc(k2, v2)
                        .assoc(k3, v3).assoc(k4, v4).assoc(k5, v5)
                        .assoc(key, val).persistent();
                return (IPersistentMap) ((IObj) map).withMeta(meta);
            }
        }

        public IPersistentMap assocEx(Object key, Object val) {
            int h = Util.hasheq(key);
            int idx = indexOf(h, key);
            if (idx >= 0) {
                throw Util.runtimeException("Key already present");
            }
            IPersistentMap map = PersistentHashMap.EMPTY.asTransient()
                    .assoc(k0, v0).assoc(k1, v1).assoc(k2, v2).assoc(k3, v3)
                    .assoc(k4, v4).assoc(k5, v5).assoc(key, val).persistent();
            return (IPersistentMap) ((IObj) map).withMeta(meta);
        }

        public IPersistentMap without(Object key) {
            int idx = indexOf(Util.hasheq(key), key);
            switch (idx) {
            case 0:
                return new Card5(meta, k1, v1, h1, k2, v2, h2, k3, v3, h3, k4,
                        v4, h4, k5, v5, h5);
            case 1:
                return new Card5(meta, k0, v0, h0, k2, v2, h2, k3, v3, h3, k4,
                        v4, h4, k5, v5, h5);
            case 2:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k3, v3, h3, k4,
                        v4, h4, k5, v5, h5);
            case 3:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k4,
                        v4, h4, k5, v5, h5);
            case 4:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k5, v5, h5);
            case 5:
                return new Card5(meta, k0, v0, h0, k1, v1, h1, k2, v2, h2, k3,
                        v3, h3, k4, v4, h4);
            default:
                return this;
            }
        }

        public int hashCode() {
            if (_hash == -1) {
                int h = 0;
                h += Util.hash(k0) ^ Util.hash(v0);
                h += Util.hash(k1) ^ Util.hash(v1);
                h += Util.hash(k2) ^ Util.hash(v2);
                h += Util.hash(k3) ^ Util.hash(v3);
                h += Util.hash(k4) ^ Util.hash(v4);
                h += Util.hash(k5) ^ Util.hash(v5);
                _hash = h;
            }
            return _hash;
        }

        public int hasheq() {
            if (_hasheq == -1) {
                int h = 0;
                h += Murmur3.mixCollHash(31 * (31 + h0) + Util.hasheq(v0), 2);
                h += Murmur3.mixCollHash(31 * (31 + h1) + Util.hasheq(v1), 2);
                h += Murmur3.mixCollHash(31 * (31 + h2) + Util.hasheq(v2), 2);
                h += Murmur3.mixCollHash(31 * (31 + h3) + Util.hasheq(v3), 2);
                h += Murmur3.mixCollHash(31 * (31 + h4) + Util.hasheq(v4), 2);
                h += Murmur3.mixCollHash(31 * (31 + h5) + Util.hasheq(v5), 2);
                _hasheq = Murmur3.mixCollHash(h, 6);
            }
            return _hasheq;
        }

        public boolean equiv(Object o) {
            if (o instanceof IPersistentMap) {
                if (!(o instanceof MapEquivalence)) {
                    return false;
                }
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 6) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o3, v3)) {
                    return false;
                }
                Object o4 = m.valAt(k4, PersistentUnrolledMap.NOT_FOUND);
                if (o4 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o4, v4)) {
                    return false;
                }
                Object o5 = m.valAt(k5, PersistentUnrolledMap.NOT_FOUND);
                if (o5 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equiv(o5, v5)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 6) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equiv(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equiv(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equiv(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equiv(v3, m.get(k3))) {
                    return false;
                }
                boolean f4 = m.containsKey(k4);
                if (!f4 || !Util.equiv(v4, m.get(k4))) {
                    return false;
                }
                boolean f5 = m.containsKey(k5);
                if (!f5 || !Util.equiv(v5, m.get(k5))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Object o) {
            if (o instanceof IPersistentMap) {
                IPersistentMap m = (IPersistentMap) o;
                if (m.count() != 6) {
                    return false;
                }
                Object o0 = m.valAt(k0, PersistentUnrolledMap.NOT_FOUND);
                if (o0 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o0, v0)) {
                    return false;
                }
                Object o1 = m.valAt(k1, PersistentUnrolledMap.NOT_FOUND);
                if (o1 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o1, v1)) {
                    return false;
                }
                Object o2 = m.valAt(k2, PersistentUnrolledMap.NOT_FOUND);
                if (o2 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o2, v2)) {
                    return false;
                }
                Object o3 = m.valAt(k3, PersistentUnrolledMap.NOT_FOUND);
                if (o3 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o3, v3)) {
                    return false;
                }
                Object o4 = m.valAt(k4, PersistentUnrolledMap.NOT_FOUND);
                if (o4 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o4, v4)) {
                    return false;
                }
                Object o5 = m.valAt(k5, PersistentUnrolledMap.NOT_FOUND);
                if (o5 == PersistentUnrolledMap.NOT_FOUND
                        || !Util.equals(o5, v5)) {
                    return false;
                }
                return true;
            } else if (o instanceof Map) {
                Map m = (Map) o;
                if (m.size() != 6) {
                    return false;
                }
                boolean f0 = m.containsKey(k0);
                if (!f0 || !Util.equals(v0, m.get(k0))) {
                    return false;
                }
                boolean f1 = m.containsKey(k1);
                if (!f1 || !Util.equals(v1, m.get(k1))) {
                    return false;
                }
                boolean f2 = m.containsKey(k2);
                if (!f2 || !Util.equals(v2, m.get(k2))) {
                    return false;
                }
                boolean f3 = m.containsKey(k3);
                if (!f3 || !Util.equals(v3, m.get(k3))) {
                    return false;
                }
                boolean f4 = m.containsKey(k4);
                if (!f4 || !Util.equals(v4, m.get(k4))) {
                    return false;
                }
                boolean f5 = m.containsKey(k5);
                if (!f5 || !Util.equals(v5, m.get(k5))) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        public int count() {
            return 6;
        }

        public IPersistentMap empty() {
            return EMPTY;
        }

        public Object kvreduce(IFn f, Object init) {
            init = f.invoke(init, k0, v0);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k1, v1);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k2, v2);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k3, v3);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k4, v4);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, k5, v5);
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f) {
            Object init = k0;
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k4, v4));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k5, v5));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Object reduce(IFn f, Object init) {
            init = f.invoke(init, new MapEntry(k0, v0));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k1, v1));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k2, v2));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k3, v3));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k4, v4));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            init = f.invoke(init, new MapEntry(k5, v5));
            if (RT.isReduced(init)) {
                return ((IDeref) init).deref();
            }
            return init;
        }

        public Iterator iterator() {
            return new Iterator() {
                int i = 0;

                public boolean hasNext() {
                    return i < 6;
                }

                public Object next() {
                    switch (i++) {
                    case 0:
                        return new MapEntry(k0, v0);
                    case 1:
                        return new MapEntry(k1, v1);
                    case 2:
                        return new MapEntry(k2, v2);
                    case 3:
                        return new MapEntry(k3, v3);
                    case 4:
                        return new MapEntry(k4, v4);
                    case 5:
                        return new MapEntry(k5, v5);
                    default:
                        throw new IndexOutOfBoundsException();
                    }
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public Object[] toArray() {
            return new Object[] { new MapEntry(k0, v0), new MapEntry(k1, v1),
                    new MapEntry(k2, v2), new MapEntry(k3, v3),
                    new MapEntry(k4, v4), new MapEntry(k5, v5) };
        }

        class UnrolledChunkedSeq extends ASeq implements IChunkedSeq, Counted {
            private final IPersistentMap meta;
            private final int offset;

            UnrolledChunkedSeq(IPersistentMap meta, int offset) {
                this.offset = offset;
                this.meta = meta;
            }

            public IChunk chunkedFirst() {
                return new ArrayChunk(toArray(), 0);
            }

            public ISeq chunkedNext() {
                return null;
            }

            public ISeq chunkedMore() {
                return PersistentList.EMPTY;
            }

            public UnrolledChunkedSeq withMeta(IPersistentMap meta) {
                return new UnrolledChunkedSeq(meta, offset);
            }

            public Object first() {
                switch (offset) {
                case 0:
                    return new MapEntry(k0, v0);
                case 1:
                    return new MapEntry(k1, v1);
                case 2:
                    return new MapEntry(k2, v2);
                case 3:
                    return new MapEntry(k3, v3);
                case 4:
                    return new MapEntry(k4, v4);
                case 5:
                    return new MapEntry(k5, v5);
                }
                throw new IndexOutOfBoundsException();
            }

            public ISeq next() {
                if (offset < 5) {
                    return new UnrolledChunkedSeq(null, offset + 1);
                }
                return null;
            }

            public int count() {
                return 6 - offset;
            }
        }

        public ISeq seq() {
            return new UnrolledChunkedSeq(null, 0);
        }
    }
}
