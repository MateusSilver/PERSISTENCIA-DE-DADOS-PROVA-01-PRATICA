# Persistencia de dados
*Prova 01 - implementação de consulta a disciplinas em xml*

* Feito com IntelliJ ultimate
* Usando Xstream para manipulação Java com permissões de XML desligadas
* Usando JDBC `ojdbc11.jar`, connector `mysql-connector-java-8.0.28.jar`


<p>Para uso de disciplina e curso separados porem 
com junção no arquivo xml é necessário unir
as duas coisas ao salvar para exibição porem separar para salvar em banco de dados</p>
<p>A desserialização de curso resultou em vários problemas, então devido a isso 
se faz necessário uma classe universidade apenas para receber cursos, 
e após, serializar usando um laço for.</p>
<p>Só ao salvar dados em banco é notável a presença de cursos 
repetidos, tendo em vista a relação 1 para 1
entre cursos e disciplinas, apenas uma consulta ao banco da tabela cursos antes de exportar é necessária, porém 
no caso das disciplinas</p>