package decorator.funcionario;

/**
 * <h1>Classe de testes do padrão Decorator para atividades de funcionário</h1>
 *
 * <p><b>O que foi adicionado nesta versão:</b></p>
 * <ul>
 *   <li><b>Cenário (a) - João</b>: Programador (80h, R$20), Implantador (40h, R$40),
 *       Treinamento de Usuario (60h, R$40).</li>
 *   <li><b>Cenário (b) - Maria</b>: Analista de sistema (90h, R$30),
 *       Testador de Software (20h, R$40), Programador (70h, R$20).</li>
 *   <li>Os cenários seguem o <i>mesmo estilo de encadeamento</i> demonstrado no
 *       exemplo original do arquivo (Pedro). Cada atividade é um decorador que
 *       envolve o componente anterior para compor o salário.</li>
 * </ul>
 *
 * <p><b>Como ler a saída:</b></p>
 * <ul>
 *   <li>O método {@code toString()} de {@link DecoradorDeAtividade} imprime,
 *       linha a linha, as atividades encadeadas e o subtotal (horas x valorHora)
 *       de cada uma.</li>
 *   <li>O método {@code calculaSalario()} acumula os subtotais usando a
 *       composição (decorators) até chegar ao salário final do mês.</li>
 * </ul>
 *
 * <p><b>Notas de implementação e alterações linha a linha:</b></p>
 * <ol>
 *   <li>Foram criados dois métodos privados, {@link #executarCenarioJoao()}
 *       e {@link #executarCenarioMaria()}, cada um encapsulando a montagem do
 *       encadeamento de atividades para o respectivo funcionário.</li>
 *   <li>Dentro de cada método:
 *     <ol type="a">
 *       <li>Instancia-se um {@link Funcionario} como componente base (folha).</li>
 *       <li>Para cada atividade do mês, instancia-se o decorador
 *           correspondente, informando (horas, valorHora).</li>
 *       <li>Chama-se {@code aponta(componenteAnterior)} para <i>encapar</i> o
 *           componente prévio, formando a cadeia decorada.</li>
 *       <li>No final, calcula-se o salário chamando {@code calculaSalario()}
 *           sobre o último decorador e imprime-se a composição completa
 *           com {@code toString()} e o valor total.</li>
 *     </ol>
 *   </li>
 *   <li>O método público {@link #execute()} apenas organiza as chamadas e imprime
 *       separadores visuais entre os cenários.</li>
 * </ol>
 */
public class Teste
{
    /**
     * Executa todos os cenários (exemplo Pedro já existente + João + Maria).
     * Este método preserva a ideia do arquivo original (um "script" de teste)
     * e adiciona as duas novas simulações exigidas pelo enunciado.
     */
    public static void execute()
    {
        // ===== Exemplo original (Pedro) do arquivo fornecido =====
        executarExemploPedro();  // Encapsulado para manter o exemplo de referência

        // ===== Novo cenário (a): João =====
        executarCenarioJoao();

        // ===== Novo cenário (b): Maria =====
        executarCenarioMaria();
    }

    /**
     * Exemplo original (Pedro) do arquivo-base, isolado como um método para
     * manter o mesmo comportamento e facilitar a leitura. Nenhuma regra foi
     * alterada — apenas movido para cá.
     */
    private static void executarExemploPedro()
    {
        // Componente folha: funcionário Pedro
        Componente pedroMes11 = new Funcionario("Pedro", "Silva");

        // Variáveis para os decoradores (atividades do mês)
        Componente a1, a2, a3, a4, a5;

        try {
            // 1) Primeira atividade: Analista de sistema (80h, 40)
            a1 = new AnalistaDeSistema(80, 40);
            a1.aponta(pedroMes11); // encapa o funcionário base

            // 2) Segunda atividade: Arquiteto de software (20h, 50)
            a2 = new ArquitetoDeSoftware(20, 50);
            a2.aponta(a1); // encapa o anterior

            // 3) Terceira atividade: Analista de sistema (40h, 40)
            a3 = new AnalistaDeSistema(40, 40);
            a3.aponta(a2);

            // 4) Quarta atividade: Arquiteto de software (20h, 100)
            a4 = new ArquitetoDeSoftware(20, 100);
            a4.aponta(a3);

            // 5) Quinta atividade: Testador de Software (20h, 30)
            a5 = new TestadorDeSoftware(20, 30);
            a5.aponta(a4);

            // Cálculo do salário mensal e impressão do detalhamento
            double salario = a5.calculaSalario();
            System.out.println("=== EXEMPLO (Pedro) ===");
            System.out.println(a5.toString());
            System.out.printf("Salario: %.2f%n%n", salario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Cenário (a) solicitado: funcionário João, com as seguintes atividades
     * no mês: Programador (80h, 20), Implantador (40h, 40),
     * Treinamento de Usuario (60h, 40).
     *
     * <p><b>Explicação passo a passo:</b></p>
     * <ol>
     *   <li>Cria-se o {@link Funcionario} "Joao".</li>
     *   <li>Instancia-se {@link Programador} com (80, 20) e aponta-se para o
     *       funcionário: agora o programador "envolve" o funcionário.</li>
     *   <li>Instancia-se {@link Implantador} com (40, 40) e aponta-se para o
     *       {@code Programador}: o implantador envolve o programador.</li>
     *   <li>Instancia-se {@link TreinamentoDeUsuario} com (60, 40) e aponta-se
     *       para o {@code Implantador}: o treinamento passa a envolver a cadeia
     *       toda.</li>
     *   <li>Calcula-se e imprime-se o salário e o detalhamento.</li>
     * </ol>
     */
    private static void executarCenarioJoao()
    {
        // 0) Componente base (folha) da composição
        Componente joaoMes = new Funcionario("Joao", "Silva");

        try {
            // 1) Programador (80h, 20)
            Componente c1 = new Programador(80, 20);
            c1.aponta(joaoMes); // encapa o funcionário

            // 2) Implantador (40h, 40)
            Componente c2 = new Implantador(40, 40);
            c2.aponta(c1); // encapa o anterior (Programador)

            // 3) Treinamento de Usuario (60h, 40)
            Componente c3 = new TreinamentoDeUsuario(60, 40);
            c3.aponta(c2); // encapa o anterior (Implantador)

            // Resultado final: chamar no último decorador da cadeia
            double salario = c3.calculaSalario();
            System.out.println("=== CENARIO (a) – Joao ===");
            System.out.println(c3.toString());
            System.out.printf("Salario: %.2f%n%n", salario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Cenário (b) solicitado: funcionária Maria, com as seguintes atividades
     * no mês: Analista de Sistema (90h, 30), Testador de Software (20h, 40),
     * Programador (70h, 20).
     *
     * <p><b>Encadeamento (ordem do "aponta"):</b> cada nova atividade envolve a
     * anterior, formando a composição Decorator.</p>
     */
    private static void executarCenarioMaria()
    {
        // 0) Base da composição
        Componente mariaMes = new Funcionario("Maria", "Souza");

        try {
            // 1) Analista de sistema (90h, 30)
            Componente c1 = new AnalistaDeSistema(90, 30);
            c1.aponta(mariaMes); // encapa o funcionário

            // 2) Testador de Software (20h, 40)
            Componente c2 = new TestadorDeSoftware(20, 40);
            c2.aponta(c1); // encapa o Analista

            // 3) Programador (70h, 20)
            Componente c3 = new Programador(70, 20);
            c3.aponta(c2); // encapa o Testador

            // Resultado final
            double salario = c3.calculaSalario();
            System.out.println("=== CENARIO (b) – Maria ===");
            System.out.println(c3.toString());
            System.out.printf("Salario: %.2f%n%n", salario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método main para possibilitar execução direta desta classe.
     * Apenas delega para {@link #execute()}.
     */
    public static void main(String[] args)
    {
        execute();
    }
}
