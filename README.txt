XML to Json
Projeto desenvolvido para conversão de arquivos XML de CTE'S para JSON de acordo com os padrões solicitados pelo cliente.
Primeiramente se faz necessário encontrar o XML, através do método File fXmlFile a pasta XMLSoprano é consumida, a API verifica se a pasta possui mais de 1 CTE ou se está vazia, então ela pode notificar o usuário ou se estiver dentro dos padrões continua para o proximo passo.
É realizado o reconhcimento do XML pelo sistema, para isto foi criado o método lerxml e métodos distintos para ler cada lista de tags do arquivo XML.
Após ler as TAGS do XML, os valores de cada tag são inseridos nos respectivos métodos da classe Documento (Que possui o padrão específicado pelo cliente).
Os valores da classe Documento são inseridos em um novo Gson e é este arquivo que será enviado ao cliente.
Através do método HttpURLConnection é feita a conexão com o servidor do cliente e o GSON é enviado.
Possui verificação do código de resposta e possui tratamento de erro de conexão, ambos enviam uma mensagem na tela do usuário com o feedback da API:
"CTE enviado com sucesso!"
"CTE incorreto ou ja cadastrado pela transportadora."
"Nao foi possivel enviar o CTE, contate o suporte."
"Falha ao enviar:"  + erroTratado

Modo de funcionamento da API no computador do usuário:

Criar pasta com nome XMLSoprano no disco C, o usuário deve colar o arquivo XML dentro desta pasta e abrir o executável JAVA, uma janela se abrirá com uma mensagem informando ao usuário se o envio foi bem sucedido ou se houve algum problema.


