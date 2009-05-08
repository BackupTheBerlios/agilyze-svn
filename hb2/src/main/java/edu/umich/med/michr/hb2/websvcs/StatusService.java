/**
 *
 */
package edu.umich.med.michr.hb2.websvcs;

import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author pboisver
 *
 */

@WebService(name = "Status")
public interface StatusService {

	@WebResult(name = "status")
	Status getStatus();

}