/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

/**
 *
 * @author Jovani
 */
public class DoublyLinkedListImplBuilder<E>{

    private Link<E> firstLink;
    private Link<E> lastLink;

    public void insertFirst(E element) {
        if (isEmpty()) {
            firstLink = new Link.Builder<>(element).build();
            lastLink = firstLink;
        } else {
            firstLink.setPrevious(new Link.Builder<>(element).next(firstLink).build());
            firstLink = firstLink.getPrevious();
        }
    }

    public void insertLast(E element) {
        if (isEmpty()) {
            insertFirst(element);
        } else {
            lastLink.setNext(new Link.Builder<>(element).previus(lastLink).build());
            lastLink = lastLink.getNext();
        }
    }

    public boolean insertAt(E element, E after) {
        if (!isEmpty()) {
            Link<E> current = firstLink;
            while (current != null) {
                if (current.getElement().equals(after)) {
                    if (current == lastLink) {
                        insertLast(element);
                    } else {
                        Link<E> temp = new Link.Builder<>(element).next(current.getNext()).previus(current).build();
                        current.getNext().setPrevious(temp);
                        current.setNext(temp);
                    }
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public E deleteFirst() {
        if (!isEmpty()) {
            Link<E> current = firstLink;
            if (current.getNext() != null) {
                current.getNext().setPrevious(null);
                firstLink = current.getNext();
            } else {
                firstLink = null;
                lastLink = null;
            }
            return current.getElement();
        }
        return null;
    }

    public E deleteLast() {
        if (!isEmpty()) {
            Link<E> current = lastLink;
            if (current.getPrevious() == null) {
                firstLink = null;
                lastLink = null;
            } else {
                current.getPrevious().setNext(null);
                lastLink = current.getPrevious();
            }
            return current.getElement();
        }
        return null;
    }

    public boolean deleteElement(E element) {
        if (!isEmpty()) {
            Link<E> current = firstLink;
            while (current != null) {
                if (current.getElement().equals(element)) {
                    if (firstLink == current) {
                        deleteFirst();
                    } else if (current == lastLink) {
                        deleteLast();
                    } else {
                        current.getNext().setPrevious(current.getPrevious());
                        current.getPrevious().setNext(current.getNext());
                    }
                    return true;
                } else {
                    current = current.getNext();
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public String displayForward() {
        Link<E> current = firstLink;
        String s = "";
        while (current != null) {
            System.out.println(current.getElement());
            s = s.concat(String.valueOf(current.getElement()));
            current = current.getNext();
        }
        return s;
    }

    public String displayBackward() {
        Link<E> current = lastLink;
        String s = "";
        while (current != null) {
            System.out.println(current.getElement());
            s = s.concat(String.valueOf(current.getElement()));
            current = current.getPrevious();
        }
        return s;
    }

    private final static class Link<E> {

        /**
         * element is the data item next is the next link in list
         */
        private final E element;
        private Link next;
        private Link previous;

        /**
         * @return the element
         */
        public E getElement() {
            return element;
        }

        /**
         * @return the next
         */
        public Link getNext() {
            return next;
        }

        /**
         * @return the previous
         */
        public Link getPrevious() {
            return previous;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Link next) {
            this.next = next;
        }

        /**
         * @param previous the previous to set
         */
        public void setPrevious(Link previous) {
            this.previous = previous;
        }

        public static class Builder<E> {

            private final E element;
            private Link next;
            private Link previous;

            public Builder(E element) {
                this.element = element;
            }

            public Builder next(Link val) {
                next = val;
                return this;
            }

            public Builder previus(Link val) {
                previous = val;
                return this;
            }

            public Link build() {
                return new Link(this);
            }
        }

        private Link(Builder builder) {
            element = (E) builder.element;
            next = builder.next;
            previous = builder.previous;
        }
    }
}
