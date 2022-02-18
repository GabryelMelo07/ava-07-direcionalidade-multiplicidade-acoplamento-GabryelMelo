package model;

import java.util.ArrayList;

public class Desenvolvedor {

  private final String nome;
  private final ArrayList<Projeto> projetos = new ArrayList<>();

  public Desenvolvedor(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Projeto> getProjetos() {
    // retornar um clone da lista para manter o encapsulamento
    return  (ArrayList<Projeto>) projetos.clone();
  }

  boolean podeSerAlocado(Projeto projeto) {
    return ! this.projetos.contains(projeto) && this.projetos.size() < 2;
  }

  void addProjeto(Projeto projeto) {
    this.projetos.add(projeto);
  }

  public void alocarNo(Projeto projeto) {
    // Não usar o getDesenvolvedores de Projeto para adicionar-se à lista
    if (this.podeSerAlocado(projeto) && projeto.podeAlocar(this)) {
      this.projetos.add(projeto);
      projeto.addDev(this);
    }
  }

  @Override
  public String toString() {
    return "DEV_" + this.nome;
  }
}
