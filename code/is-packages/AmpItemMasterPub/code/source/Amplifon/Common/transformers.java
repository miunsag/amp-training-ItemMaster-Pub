package Amplifon.Common;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
// --- <<IS-END-IMPORTS>> ---

public final class transformers

{
	// ---( internal utility methods )---

	final static transformers _instance = new transformers();

	static transformers _newInstance() { return new transformers(); }

	static transformers _cast(Object o) { return (transformers)o; }

	// ---( server methods )---




	public static final void mapDateToIsoDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(mapDateToIsoDate)>> ---
		// @sigtype java 3.5
		// [i] object:0:optional date
		// [o] field:0:optional isoDate
		Object	date = null;
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		boolean exists = pipelineCursor.first("date");
		if (exists) date = pipelineCursor.getValue();
		pipelineCursor.destroy();
		
		if (!exists) return;
		
		String nowAsISO = null;
		if(null != date){
		java.util.TimeZone tz = java.util.TimeZone.getTimeZone("UTC");
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		nowAsISO = df.format((java.util.Date)date);
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "isoDate", nowAsISO );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void mapDateToIsoDateTime (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(mapDateToIsoDateTime)>> ---
		// @sigtype java 3.5
		// [i] object:0:optional date
		// [o] field:0:optional isoDate
		Object	date = null;
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		boolean exists = pipelineCursor.first("date");
		if (exists) date = pipelineCursor.getValue();
		pipelineCursor.destroy();
		
		if (!exists) return;
		
		String nowAsISO = null;
		if(null != date){
		java.util.TimeZone tz = java.util.TimeZone.getTimeZone("UTC");
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(tz);
		nowAsISO = df.format((java.util.Date)date);
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "isoDate", nowAsISO );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

