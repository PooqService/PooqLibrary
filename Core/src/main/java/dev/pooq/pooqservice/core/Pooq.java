package dev.pooq.pooqservice.core;

public class Pooq {

  private static PooqService service;

  public static PooqService getService(){
    if(service != null){
      return service;
    }

    return service = new PooqService();
  }
}
