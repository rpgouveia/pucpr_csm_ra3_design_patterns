# Trabalho 3 — Design Patterns (Decorator, Composite, State e Interpreter)

Este repositório reúne a implementação e o material de apoio do **Trabalho 3** da disciplina **Modelagem de Sistemas Computacionais**, cobrindo quatro padrões de projeto clássicos: **Decorator**, **Composite**, **State** e **Interpreter**. O objetivo é **modelar e codificar** soluções orientadas a objetos, reforçando boas práticas de projeto, leitura de modelos UML e comunicação técnica.

> **Autores**
>
> * Angelo Piovezan Jorgeto
> * Fernando Alonso P. da Silva
> * **Jafte Carneiro F. da Silva**
> * Renato P. Gouveia

---

## 🔎 Visão geral

* **Decorator (funcionário/atividades)**: modela a composição dinâmica de **atividades** realizadas por um funcionário ao longo de um período (mês). Cada atividade adiciona valor ao salário final sem alterar a classe base, usando empilhamento de decoradores.
* **Composite**: estrutura hierarquias parte–todo (por exemplo, pastas/arquivos, departamentos/equipes), permitindo tratar elementos individuais e composições de forma uniforme.
* **State**: encapsula mudanças de comportamento conforme o **estado interno** de um objeto (ex.: pedido que transita entre “Novo”, “Pago”, “Enviado”).
* **Interpreter**: define uma gramática simples e um interpretador para avaliar expressões da linguagem (por exemplo, filtros, regras ou expressões aritméticas/lógicas).

Além do **código Java**, o trabalho inclui o **modelo UML (Astah)** que guia a implementação e facilita a revisão.

---

## 🗂 Estrutura do projeto

```
/decorator/
  └── funcionario/
      ├── Componente.java
      ├── Funcionario.java
      ├── DecoradorDeAtividade.java
      ├── AnalistaDeSistema.java
      ├── ArquitetoDeSoftware.java
      ├── TestadorDeSoftware.java
      ├── Programador.java                 # (novo)
      ├── Implantador.java                 # (novo)
      ├── TreinamentoDeUsuario.java        # (novo)
      └── Teste.java                       # (cenários Pedro, João e Maria)

# (Os demais padrões seguem pastas/arquiteturas próprias, conforme orientação do enunciado)
# /composite/...
# /state/...
# /interpreter/...

/doc/
  ├── Trabalho 3 Engenharia Reversa.asta   # diagrama no Astah (atualizado)
  └── diagrama-de-classes.png              # visão do pacote decorator->funcionario

README.md
```

> **Nota**: a organização dos diretórios dos demais padrões (Composite/State/Interpreter) deve acompanhar os nomes de pacotes planejados no UML e no enunciado. Este README já antecipa a estrutura para manter a coesão do repositório.

---

## 🧩 Destaques por padrão

### 1) Decorator — Apontamento de atividades de funcionário

* **Motivação**: funcionários podem acumular **atividades dinâmicas** (ex.: Programador, Analista, Testador, etc.). Cada atividade agrega valor ao salário, e a combinação muda mês a mês.
* **UML (resumo)**:

  * `Componente` (abstrata) define a interface comum.
  * `Funcionario` (folha) representa o colaborador.
  * `DecoradorDeAtividade` (abstrata) envolve um `Componente` e adiciona comportamento/estado (`numeroDeHoras`, `valorHora`).
  * Subclasses concretas de `DecoradorDeAtividade`:
    `AnalistaDeSistema`, `ArquitetoDeSoftware`, `TestadorDeSoftware`, **`Programador`**, **`Implantador`**, **`TreinamentoDeUsuario`**.
* **Cálculo**: `calculaSalario()` em cada decorador soma `(horas × valorHora)` ao resultado do componente decorado.
* **Cenários em `Teste.java`**:

  * **Exemplo de referência** (Pedro) — mantido.
  * **Cenário (a) João**:
    Programador (80h, 20) → Implantador (40h, 40) → TreinamentoDeUsuario (60h, 40)
  * **Cenário (b) Maria**:
    AnalistaDeSistema (90h, 30) → TestadorDeSoftware (20h, 40) → Programador (70h, 20)
* **Observações de implementação**:

  * As novas classes seguem fielmente o padrão das existentes (construtor `(double nh, double vh)`, uso do `toString()` herdado no decorador, mesma assinatura de métodos).
  * `Teste.java` contém **Javadoc** e **comentários detalhados** explicando passo a passo o encadeamento e o cálculo.

### 2) Composite — (resumo do objetivo)

* Estruturar **árvores** de objetos (componentes e composições) com operações uniformes (ex.: `add`, `remove`, `getChild`, `operacao()`).
* Permite percorrer a estrutura sem distinguir entre folha e composição na maior parte dos casos.

### 3) State — (resumo do objetivo)

* Encapsular os **estados** e suas **transições** dentro de objetos estado, evitando condicionais complexas espalhadas.
* Cada classe de estado implementa o comportamento próprio e decide transições (ex.: `Pagar()`, `Enviar()`, `Cancelar()`).

### 4) Interpreter — (resumo do objetivo)

* Definir uma **gramática** simples (terminais e não-terminais) e implementá-la com uma árvore de sintaxe (expressões).
* Avaliação via `interpret(Contexto ctx)` para processar regras/expressões sobre um ambiente de execução.

---

## ▶️ Execução (Decorator)

Compilar a partir da raiz do projeto (ajuste o caminho conforme sua organização local):

```bash
# Exemplo com javac/jre padrão
javac decorator/funcionario/*.java
java decorator.funcionario.Teste
```

**Saída esperada**: detalhamento textual das atividades encadeadas (por funcionário) e o **salário total** calculado a partir da composição de decoradores.

---

## 🛠 Requisitos

* **JDK 11+** (recomendado)
* IDE a gosto (IntelliJ, Eclipse, VS Code)
* **Astah** para abrir o arquivo `.asta`

---

## 📐 Modelo UML (Astah)

* Arquivo: `doc/Trabalho 3 Engenharia Reversa.asta`
* O diagrama do pacote `decorator -> funcionario` foi **atualizado** com as três novas atividades:

  * **Programador**, **Implantador**, **TreinamentoDeUsuario**
* Captura de referência: `doc/diagrama-de-classes.png`

---

## 📄 Licença

Definir conforme decisão do grupo (ex.: MIT). Até lá, considerar **uso acadêmico**.

---

Se precisar, posso gerar uma **versão em PDF** deste README, um **script de build** (`Makefile` ou `maven/gradle`) e um **roteiro de apresentação** alinhado ao que o enunciado pede.
