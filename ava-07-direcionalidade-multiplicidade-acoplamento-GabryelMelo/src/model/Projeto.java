package model;

import java.util.ArrayList;

public class Projeto {

  private final String nome;
  private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

  public Projeto(String nome) {
    this.nome = nome;
  }

  public Projeto(String nome, Desenvolvedor... dev) {
    this.nome = nome;
    for (int i = 0; i < dev.length; i++) {
      this.alocarDev(dev[i]);
    }
  }

  public String getNome() {
    return this.nome;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Desenvolvedor> getDesenvolvedores() {
    // retornar um clone da lista para manter o encapsulamento
    return (ArrayList<Desenvolvedor>) desenvolvedores.clone();
  }

  boolean podeAlocar(Desenvolvedor dev) {
    return ! this.desenvolvedores.contains(dev) && this.desenvolvedores.size() < 5;
  }

  void addDev(Desenvolvedor dev) {
    this.desenvolvedores.add(dev);
  }

  public void alocarDev(Desenvolvedor dev) {
    // não usar getProjetos de Desenvolvedor para adicionar-se à lista
    if (this.podeAlocar(dev) && dev.podeSerAlocado(this)) {
      this.desenvolvedores.add(dev);
      dev.addProjeto(this);
    }
  }

  @Override
  public String toString() {
    return "PROJ_" + this.nome;
  }

  public boolean hasDesenvolvedor(Desenvolvedor dev) {
    // Implementar retornando se o dev faz parte da equipe ou não
    if(desenvolvedores.contains(dev)){
      return true;
    }
    return false;
  }

}
