# Projeto RPC com Sockets e JSON-RPC

Este repositório contém a implementação de um sistema Cliente-Servidor baseado em comunicação RPC (Remote Procedure Call) utilizando Sockets TCP e o padrão JSON-RPC. O projeto foi desenvolvido como um trabalho acadêmico e implementa três serviços matemáticos e lógicos.

## O que foi realizado (5 Etapas)

**1. Configuração da Arquitetura RPC**
Estabelecemos a ponte de comunicação entre o Cliente (onde o usuário interage via terminal) e o Servidor (onde os cálculos pesados ocorrem). Utilizamos a biblioteca Gson para empacotar as requisições em formato JSON (`JsonRpcRequest`) e desempacotar as respostas (`JsonRpcResponse`), permitindo uma troca de dados limpa.

**2. Implementação do Cálculo de PI (Série de Leibniz)**
No arquivo `PiService.java`, foi implementado o cálculo de Pi utilizando o método da série matemática de Leibniz. Foi definido um loop de alta performance com 1.000.000 de iterações para garantir precisão exigida. Ao final, utilizamos a classe `BigDecimal` para "cortar" e retornar o valor exatamente com a quantidade de casas decimais que o usuário solicitou.

**3. Integração do Baskara e Tratamento de Entrada**
O método para encontrar raízes de equações quadráticas foi refinado. Além de tratar cenários sem raízes reais (Delta < 0), ajustamos a interface de terminal (TUI) do Cliente, forçando o padrão americano (`Locale.US`). Isso impede falhas graves se o usuário digitar pontos no lugar de vírgulas (ex: `1.5`) e facilita a inserção rápida dos coeficientes.

**4. Estatísticas de Texto Avançadas**
Criamos no servidor o serviço `PalavrasService` que recebe um texto do usuário e devolve 9 estatísticas completas. O algoritmo itera pela String para identificar e contar vogais puras, vogais acentuadas, consoantes (incluindo cedilha) e espaços. Além disso, ele limpa a pontuação das palavras antes de medir se o comprimento delas é um número par ou ímpar.

**5. Otimização, Polimento e Segurança**
Finalizamos o projeto limpando as pontas soltas reportadas pelos analisadores da IDE:
- Implementamos alertas limpos e customizados no Cliente caso ele tente se conectar a um Servidor offline, evitando o estouro de `NullPointerException`.
- Corrigimos "Vazamentos de Recursos" (Resource Leaks) inserindo o `.close()` adequadamente no Scanner.
- Removemos a redundância de Sockets no `try-with-resources`.
