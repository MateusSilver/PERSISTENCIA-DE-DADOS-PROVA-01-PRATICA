# Persistencia de dados

_Prova 01 - implementação de consulta a disciplinas em xml_

- Feito com IntelliJ ultimate
- Usando Xstream para manipulação Java com permissões de XML desligadas
- Usando JDBC `ojdbc11.jar`, connector `mysql-connector-java-8.0.28.jar`

<p>Para uso de disciplina e curso separados porem 
com junção no arquivo xml é necessário unir
as duas coisas ao salvar para exibição porem separar para salvar em banco de dados</p>
<p>A desserialização de curso resultou em vários problemas, então devido a isso 
se faz necessário uma classe universidade apenas para receber cursos, 
e após, serializar usando um laço for.</p>
<p>Só ao salvar dados em banco é notável a presença de cursos 
repetidos, supondo a relação  1 para 1
entre cursos e disciplinas, a opção escolhida foi alterar a tabela curso para ter 
a chave primaria sendo iden e nome, outars opções seriam dar novos iden para cada curso repetido, observando com uma consulta ao banco
e alterar os nomes para o nome da primeira instancia, ao inves de inserir algo novo.</p>
