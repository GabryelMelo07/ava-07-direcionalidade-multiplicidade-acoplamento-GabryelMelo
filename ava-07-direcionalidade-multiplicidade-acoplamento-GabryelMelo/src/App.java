import model.*;

public class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    // Considere três projetos
    Projeto projetoBanco      = new Projeto("Banco");
    Projeto projetoEcommerce  = new Projeto("E-Commerce");
    Projeto projetoRedeSocial = new Projeto("Rede Social");
    Projeto projetoERP        = new Projeto("ERP");

    // Considere 7 desenvolvedores(as)
    Desenvolvedor devFlavia  = new Desenvolvedor("Flavia");
    Desenvolvedor devArtur   = new Desenvolvedor("Artur");
    Desenvolvedor devNatalia = new Desenvolvedor("Natalia");
    Desenvolvedor devPedro   = new Desenvolvedor("Pedro");
    Desenvolvedor devRoberta = new Desenvolvedor("Roberta");
    Desenvolvedor devRogerio = new Desenvolvedor("Rogerio");
    Desenvolvedor devMarina  = new Desenvolvedor("Marina");

    // Um projeto pode ter um dev alocado à ele:
    projetoBanco.alocarDev(devFlavia);

    // Ao mesmo tempo que o Projeto tem Desenvolvedores.
    // Desesenvolvedores têm Projetos (tá aí a bidirecionalidade).
    System.out.println(projetoBanco.getDesenvolvedores());
    System.out.println(devFlavia.getProjetos().size() == 1);
    System.out.println(devFlavia.getProjetos());

    projetoEcommerce.alocarDev(devFlavia);
    System.out.println(devFlavia.getProjetos().size() == 2);
    System.out.println(devFlavia.getProjetos());

    projetoRedeSocial.alocarDev(devFlavia);
    System.out.println(devFlavia.getProjetos().size() == 2);
    System.out.println(devFlavia.getProjetos());

    // é possível adicionar projetos ao dev e devs ao projeto
    // enquanto os get's retornarem a lista real em vez de um clone.
    // Deve retornar um clone da lista e não causar efeito.
    devFlavia.getProjetos().add(projetoEcommerce); // não deveria causar efeito
    devFlavia.getProjetos().add(projetoRedeSocial); // não deveria causar efeito
    // mas causa a inconsistência:
    System.out.println(devFlavia.getProjetos().size() == 2); // FALSE, deveria ser TRUE
    System.out.println(devFlavia.getProjetos());

    // não expor os métodos contratuais entre dev e projeto,
    // o método podeSerAlocado deveria ser inacessível para o App.java
    // System.out.println(devFlavia.podeSerAlocado(projetoRedeSocial)); // comentar

    devArtur.alocarNo(projetoERP);
    devNatalia.alocarNo(projetoERP);
    devPedro.alocarNo(projetoERP);
    devRoberta.alocarNo(projetoERP);
    devRogerio.alocarNo(projetoERP);
    devMarina.alocarNo(projetoERP); // Dev Marina não foi adicionada ao projetoERP pois as 5 vagas já foram preenchidas.

    System.out.println(projetoERP.getDesenvolvedores().size() == 5);

    // Consultando se um dev está no projeto:
    System.out.println(projetoERP.hasDesenvolvedor(devArtur)   == true);
    System.out.println(projetoERP.hasDesenvolvedor(devRoberta) == true);
    System.out.println(projetoERP.hasDesenvolvedor(devMarina)  == false);

    // sobrecarregar construtor
    Projeto projetoEdu = new Projeto("Educação", devArtur, devRoberta, devMarina);

    // escrever testes
    System.out.println(projetoEdu.getDesenvolvedores().size() == 3);
    System.out.println(devArtur.getProjetos().size() == 2);
    System.out.println(devRoberta.getProjetos().size() == 2);
    System.out.println(devMarina.getProjetos().size() == 1);
    System.out.println(projetoEdu.hasDesenvolvedor(devArtur));
    System.out.println(projetoEdu.hasDesenvolvedor(devRoberta));
    System.out.println(projetoEdu.hasDesenvolvedor(devMarina));

  }
}
