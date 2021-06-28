<h1 align="center">
  <span> Desafio Zup -> Orange Talents -> 2021 </span>
</h1>
<h2>Sobre o Desafio (Projeto)</h2>

<ul>
  <li>Efetuar a criação de uma API Rest que irá controlar veículos de usuários.</li>
  <ul>
    <li>Primeiro passo: Efetuar a criação de um cadastro de usúarios, onde, os seguintes dados serão obrigatórios: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos.</li>
    <li>Segundo passo: Efetuar a criação de um cadastro de veículos, onde, os seguintes dados serão obrigatórios: Marca, Modelo do Veículo e Ano. O Serviço em si deve consumir a API da FIPE(https://deividfortuna.github.io/fipe/) para obter os dados do veículo baseado nas informações inseridas.</li>
    <li>Terceiro passo: Buscar criar um endpoint que retornará um usuário com a lista de todos os seus veículos cadastrados.</li>
    <br>
    <li>Observações:</li>
    <ul>
       <li>Você deve construir 3 endpoints neste sistema, o cadastro do usuário, o cadastro de veículo e a listagem dos veículos para um usuário em específico.</li>
       <li>No endpoint que listará seus veículos, devemos considerar algumas configurações a serem exibidas para o usuário final. Será preciso criar dois novos atributos no objeto do carro, sendo eles: </li>
       <br>
       <ol>
         <li>Dia do rodízio deste carro, baseado no último dígito do ano do veículo, considerando as condicionais:</li>
         <ul>
           <li>Final 0-1: segunda-feira</li>
           <li>Final 2-3: terça-feira</li>
           <li>Final 4-5: quarta-feira</li>
           <li>Final 6-7: quinta-feira</li>
           <li>Final 8-9: sexta-feira</li>
         </ul>
         <br>
         <li>Também deve ser criado um atributo de rodízio ativo, que irá comparar a data atual do sistema com as condicionais anteriores e, quando for o dia ativo do rodízio, retornará true, caso contrário, false.</li>
         <ul>
           <li>Exemplo A: Hoje é segunda-feira, o carro é da marca Fiat, modelo Uno do ano de 2001, ou seja, seu rodízio será às segundas-feiras e o atributo de rodízio ativo será TRUE.</li>
           <li>Exemplo B: Hoje é quinta-feira, o carro é da marca Hyundai, modelo HB20 do ano de 2021, ou seja, seu rodízio será às segundas-feiras e o atributo de rodízio ativo será FALSE.</li>
           <br>
           <li>Caso os cadastros estejam corretos, é necessário voltar o status 201. Caso hajam erros de preenchimento de dados, o Status deve ser 400.</li>
           <li>Caso a busca esteja correta, é necessário voltar o status 200. Caso haja erro na busca, deve retornar o status adequado e uma mensagem de erro amigável.</li>
         </ul>
       </ol>
    </ul>
  </ul>
</ul>



<h2>Iniciando o desafio</h2>
