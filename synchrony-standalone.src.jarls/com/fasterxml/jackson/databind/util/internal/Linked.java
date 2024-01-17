package com.fasterxml.jackson.databind.util.internal;

interface Linked<T extends Linked<T>> {
  T getPrevious();
  
  void setPrevious(T paramT);
  
  T getNext();
  
  void setNext(T paramT);
}
