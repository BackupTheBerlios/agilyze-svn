/**
 *
 */
package edu.umich.med.michr.hb2.websvcs;

import javax.jws.WebService;

/**
 * @author pboisver
 *
 */
@WebService(endpointInterface="edu.umich.med.michr.hb2.websvcs.StatusService")
public class StatusServiceImpl implements StatusService {

	/* (non-Javadoc)
	 * @see edu.umich.med.michr.hb2.websvcs.StatusService#getStatus()
	 */
	public Status getStatus() {
		// TODO Auto-generated method stub
		return new Status();
	}

}
