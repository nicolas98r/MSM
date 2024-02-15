package com.store.msm.exceptions;

public class ItemExitsException extends RuntimeException {
    public ItemExitsException(String item_id) {
        super("El item " + item_id + " ya existe, no se puede modificar");
    }
}
