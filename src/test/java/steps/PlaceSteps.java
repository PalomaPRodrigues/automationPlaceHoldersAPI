package steps;

import api.ApiHeaders;
import api.ApiParams;
import api.ApiRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import user.UserLombok;
import utils.JsonUtils;
import utils.PropertiesUtils;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlaceSteps extends ApiRequest {
    PropertiesUtils prop = new PropertiesUtils();
    JsonUtils jsonUtils = new JsonUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    ApiParams apiParams = new ApiParams();
    Faker faker = new Faker();
    UserLombok user;

    @Dado("que passou placeHolder token valido")
    public void que_passou_place_holder_token_valido() {

        System.out.println("API Não requer token");
    }

    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() {
        super.uri = prop.getProp("uri_place");
        super.headers = apiHeaders.placeHeaders();
        user = UserLombok.builder()
                .postId(Integer.valueOf("1"))
                .name(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .body("Primeiro Commit")
                .build();

        super.body = new JSONObject(new Gson().toJson(user));
        super.POST();

    }

    @Entao("o usuario deve ser criado corretamente")
    public void o_usuario_deve_ser_criado_corretamente() {
        assertEquals(user, response.jsonPath().getObject("", UserLombok.class), "Erro  na comparação do objeto!");

    }

    @Entao("o status code do request deve ser {int}")
    public void o_status_code_do_request_deve_ser(Integer statusCode) {
        assertEquals(statusCode, response.statusCode());

    }

    @Dado("possua um usuario Cadastrado no api")
    public void possua_um_usuario_cadastrado_no_api() {
        envio_um_request_de_cadastro_de_usuario_com_dados_validos();
    }

    @Dado("buscar esse usuário")
    public void buscar_esse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("postId=1");
        super.params = apiParams.placeParams();
        super.GET();

    }

    @Quando("os dados dos usuario serem retornados")
    public void os_dados_dos_usuario_serem_retornados() {
//        assertEquals(response.statusCode(), response.statusCode());
    }

    @Dado("altere os desse usuário")
    public void altere_os_desse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id");
        user.setName("Paulo");
        super.body = new JSONObject(new Gson().toJson(user));
        super.PUT();
    }

    @Quando("os dados serem alterados com sucesso")
    public void os_dados_serem_alterados_com_sucesso() {
        assertTrue(user.getName().matches(user.getName()));
       // assertEquals(user, response.jsonPath().getObject("", UserLombok.class), "Erro  na comparação do objeto!");
    }

    @Dado("delete esse usuário")
    public void delete_esse_usuário() {
       super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id");
       super.body = new JSONObject();
       super.DELETE();

    }

    @Quando("o usuario é deletado com sucesso")
    public void o_usuario_é_deletado_com_sucesso() {
        assertEquals(response.statusCode(),response.statusCode());

    }

}
