package com.store.msm.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String item_id) {
        super("El item " + item_id + " no existe");
    }
}
