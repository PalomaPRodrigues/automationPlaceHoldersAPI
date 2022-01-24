package steps;

import api.ApiHeaders;
import api.ApiRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import user.UserLombok;
import utils.PropertiesUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlaceSteps extends ApiRequest {
    PropertiesUtils prop = new PropertiesUtils();
    ApiHeaders apiHeaders = new ApiHeaders();
    Faker faker = new Faker();
    UserLombok user;

    @Dado("que Api Placeholders não solicita token")
    public void que_api_placeholders_não_solicita_token() {
        System.out.println("API Não requer token");
    }


    @Quando("envio um request de cadastro de usuario com dados validos")
    public void envio_um_request_de_cadastro_de_usuario_com_dados_validos() {
        super.uri = prop.getProp("uri_place");
        super.headers = apiHeaders.placeHeaders();
        user = UserLombok.builder()
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

    @Dado("consulta esse usuário")
    public void consulta_esse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id=1");
        super.headers = apiHeaders.placeHeaders();
        super.body = new JSONObject();
        super.GET();
    }

    @Quando("os dados dos usuario serem retornados")
    public void os_dados_dos_usuario_serem_retornados() {
        assertEquals("id labore ex et quam laborum", response.jsonPath().getString("name"));
    }

    @Dado("altere os dados desse usuário")
    public void altere_os_dados_desse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id=1");
        super.headers = apiHeaders.placeHeaders();
        user.setName("Carla");
        super.body = new JSONObject(new Gson().toJson(user));
        super.PUT();
    }

    @Quando("os dados serem alterados com sucesso")
    public void os_dados_serem_alterados_com_sucesso() {
        assertEquals(user, response.jsonPath().getObject("", UserLombok.class), "Erro  na comparação!");
    }

    @Quando("altero  um ou mais dados do usuario")
    public void alteroUmOuMaisDadosDoUsuario() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id=1");
        super.headers = apiHeaders.placeHeaders();
        user.setEmail("carla.rodrigues@gmail.com");
        super.body = new JSONObject("{\"email\": \"carla.rodrigues@gmail.com\"}");
        super.PATCH();
    }

    @Quando("todos dados serem alterados com sucesso")
    public void todos_dados_serem_alterados_com_sucesso() {
        assertEquals(body.getString("email"), response.jsonPath().getString("email"));

    }

    @Dado("delete esse usuário")
    public void delete_esse_usuário() {
        super.uri = prop.getProp("uri_place") + "/" + response.jsonPath().getJsonObject("id=1");
        super.body = new JSONObject(new Gson().toJson(user));
        super.DELETE();
    }

    @Quando("o usuario é deletado com sucesso")
    public void o_usuario_é_deletado_com_sucesso() {

        Assert.assertEquals(200, response.statusCode());
    }

}
