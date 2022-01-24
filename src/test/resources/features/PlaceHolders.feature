#language: pt
#Author: Paloma
#Version: 1.0

@PlaceHolders
Funcionalidade: Criar, editar e deletar contas de usuários
  Eu como Administrador do sistema, quero cadastrar, buscar, alterar e deletar usuarios do sistema

  @post
    Cenario: Cadastrar Usuário
    Dado que Api Placeholders não solicita token
    Quando  envio um request de cadastro de usuario com dados validos
    Entao o usuario deve ser criado corretamente
    E o status code do request deve ser 201

  @get
  Cenario: Consultar um usuário Cadastrado na API PlaceHolders
    Dado que Api Placeholders não solicita token
    E possua um usuario Cadastrado no api
    E consulta esse usuário
    Quando os dados dos usuario serem retornados
    Entao o status code do request deve ser 200

  @put
  Cenario: Alterar dados do usuário Cadastrado na API PlaceHolders
    Dado que Api Placeholders não solicita token
    E possua um usuario Cadastrado no api
    E altere os dados desse usuário
    Quando os dados serem alterados com sucesso
    Entao o status code do request deve ser 200

  @patch
  Cenario: Alterar um ou mais dados do usuário Cadastrado na API  PlaceHolders
    Dado que Api Placeholders não solicita token
    E possua um usuario Cadastrado no api
    E altero  um ou mais dados do usuario
    Quando todos dados serem alterados com sucesso
    Entao o status code do request deve ser 200

  @delete
  Cenario: Deletar um usuário Cadastrado na API PlaceHolders
    Dado que Api Placeholders não solicita token
    E possua um usuario Cadastrado no api
    E delete esse usuário
    Quando o usuario é deletado com sucesso
    Entao o status code do request deve ser 200
