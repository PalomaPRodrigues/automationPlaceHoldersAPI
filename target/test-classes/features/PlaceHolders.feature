#language: pt
#Author: Paloma
#Version: 1.0

@PlaceHolders
Funcionalidade: Criar, editar e deletar contas de usuários
  Eu como Administrador do sistema, quero cadastrar, buscar, alterar e deletar usuarios do sistema

  @post
    Cenario: Cadastrar Usuário
    Dado que passou placeHolder token valido
    Quando  envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do request deve ser 201

  @get
  Cenario: Buscar um usuário Cadastrado na API PlaceHolders
    Dado que passou placeHolder token valido
    E possua um usuario Cadastrado no api
    E buscar esse usuário
    Quando os dados dos usuario serem retornados
    Então o status code do request deve ser 200

  @put
  Cenario: Alterar um usuário Cadastrado na API PlaceHolders
    Dado que passou placeHolder token valido
    E possua um usuario Cadastrado no api
    E altere os desse usuário
    Quando os dados serem alterados com sucesso
    Então o status code do request deve ser 200

  @patch
  Cenario: Alterar um usuário existente na API Gorest PATCH
    Dado que passou placeHolder token valido
    E possua um usuario Cadastrado no api
    Quando altero  um ou mais dados do usuario
    Quando todos dados serem alterados com sucesso
    Então o status code do request deve ser 200

  @delete
  Cenario: Deletar um usuário Cadastrado na API PlaceHolders
    Dado que passou placeHolder token valido
    E possua um usuario Cadastrado no api
    E delete esse usuário
    Quando o usuario é deletado com sucesso
    Então o status code do request deve ser 200
