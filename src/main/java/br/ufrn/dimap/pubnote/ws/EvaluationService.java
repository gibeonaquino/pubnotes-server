package br.ufrn.dimap.pubnote.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ufrn.dimap.pubnote.dao.EvaluationDAO;
import br.ufrn.dimap.pubnote.dao.EvaluationDAOFactory;
import br.ufrn.dimap.pubnote.domain.Evaluation;

@Path( "/evaluation" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class EvaluationService 
{
	/** dao utilized to do the operations of evaluation**/
	EvaluationDAO evalDao;
	
	/**
	 * curl -i   -H "Content-Type: application/json" -X POST -d '{"originality":"2.4", "contribution":"4.2", "relevance":"2.3", "readability":"4.6", "relatedWorks":"4.5", "reviewerFamiliarity":"2.4"}' http://localhost:8080/pubnote.server/rest/evaluation/new  
	 * @param user
	 * @return
	 */	
	@POST
	@Path("/new")
	public Response createEvaluation(Evaluation evaluation){		
		//TODO: complete functionality here
		EvaluationDAOFactory factory = new EvaluationDAOFactory();
		evalDao = factory.createDAO();
		evalDao.persist(evaluation);
				
		return Response.status(201).build();
	}
}
