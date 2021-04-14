package Practice5;

public class ObjectQueue<T> {
    // Указатель на первый элемент
    private ObjectBox head = null;
    // Указатель на последний элемент
    private ObjectBox tail = null;
    // Поле для хранения размера очереди
    private int size = 0;

    public void push(T obj) {
        // Сразу создаем вспомогательный объект и помещаем новый элемент в него
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);
        // Если очередь пустая - в ней еще нет элементов
        if (head == null) {
        // Теперь наша голова указывает на наш первый элемент
            head = ob;
        } else {
        // Если это не первый элемент, то надо, чтобы последний элемент в очереди
        // указывал на вновь прибывший элемент
            tail.setNext(ob);
        }
        // И в любом случае нам надо наш "хвост" переместить на новый элемент
        // Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент
        tail = ob;
        // Увеличиваем размер нашей очереди
        size++;
    }

    public T pull() {
        // Если у нас нет элементов, то возвращаем
        if (size == 0) {
            return null;
        }
        // Получаем наш объект из вспомогательного класса из "головы"
        T obj = head.getObject();
        // Перемещаем "голову" на следующий элемент
        head = head.getNext();
        // Если это был единственный элемент, то head станет равен
        // и тогда tail (хвост) тоже дожен указать на null.
        if (head == null) {
            tail = null;
        }
        // Уменьшаем размер очереди
        size--;
        // Возвращаем значение
        return obj;
    }

    public T get(int index) {
        // Если нет элементов или индекс больше размера или индекс меньше 0
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        // Устанавлваем указатель, который будем перемещать на "голову"
        ObjectBox current = head;
        // В этом случае позиция равна 0
        int pos = 0;
        // Пока позиция не достигла нужного индекса
        while (pos < index) {
            // Перемещаемся на следующий элемент
            current = current.getNext();
            // И увеличиваем позицию
            pos++;
        }
        // Мы дошли до нужной позиции и теперь можем вернуть элемент
        T obj = current.getObject();
        return obj;
    }

    public int size() {
        return size;
    }

    // Наш вспомогательный класс будет закрыт от посторонних глаз
    private class ObjectBox {
        // Поле для хранения объекта
        private T object;
        // Поле для указания на следующий элемент в цепочке.
        // Если оно равно Null - значит это последний элемент
        private ObjectBox next;

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }
    }
}