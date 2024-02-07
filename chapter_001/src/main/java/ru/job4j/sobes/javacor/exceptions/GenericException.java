package ru.job4j.sobes.javacor.exceptions;

public class GenericException<T>{// extends RuntimeException{
    private T info;
    public GenericException(String message, T info) {
//        super(message);
        this.info = info;
    }

    public static void main(String[] args) {
        try {
//            doLogic();
        } catch (Exception e) {
//            handle(e);   джинерики для эксепшнов не разрешены - не понятно что ловить будет
//        } catch (GenericException<DbConnectionIbfo> | GenericException<NotfoundInfo>
//                | GenericException<HttpIbfo> genericEx) {
//            handleGenericException(genericEx);
        }
    }
}
