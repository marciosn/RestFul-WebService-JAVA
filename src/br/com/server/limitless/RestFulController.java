package br.com.server.limitless;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.server.limitless.service.ServiceCustomRequests;

@Path("/v1")
public class RestFulController {
	
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@Path("/teste")
	@GET
	@Produces("application/json")
	public Response teste(){
		ServiceCustomRequests requests = new ServiceCustomRequests();
		Response response = requests.sendGet("http://marciosn.github.io/JSON/json/pessoa_juridica_cpf.json");
		return response;
	}
	
	@Path("/cnpj/captcha")
	@POST
	@Produces("application/json")
	public Response cnpjCaptcha(){
		ServiceCustomRequests requests = new ServiceCustomRequests();
		Response response = requests.executePost("https://movel01.receita.fazenda.gov.br:443/servicos-rfb/v2/ConsultaCNPJ/captcha/post");
		return response;
	}
	
	@Path("/cnpj/captcha")
	@GET
	@Produces("application/json")
	public Response getCnpjCaptcha(){
		ServiceCustomRequests requests = new ServiceCustomRequests();
		Response response = requests.executePost("https://movel01.receita.fazenda.gov.br:443/servicos-rfb/v2/ConsultaCNPJ/captcha/post");
		return response;
	}
}
