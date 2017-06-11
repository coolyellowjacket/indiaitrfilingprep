package com.taxapp.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxapp.datapackets.AgricultureIncomeData;
import com.taxapp.datapackets.AllData;
import com.taxapp.datapackets.DividendIncomeData;
import com.taxapp.datapackets.ExemptionsData;
import com.taxapp.datapackets.GiftIncomeData;
import com.taxapp.datapackets.ITRClassificationData;
import com.taxapp.datapackets.ITRData;
import com.taxapp.datapackets.InterestIncomeData;
import com.taxapp.datapackets.MachineryIncomeData;
import com.taxapp.datapackets.PaymentData;
import com.taxapp.datapackets.RegistrationData;
import com.taxapp.datapackets.RentalIncomeData;
import com.taxapp.datapackets.SalaryIncomeData;
import com.taxapp.datapackets.TaxData;
import com.taxapp.datapackets.TaxExemptMinorIncomeData;
import com.taxapp.datapackets.UserDetails;
import com.taxapp.datapackets.UserSessionInfo;

public class JSONUtils {
	public static String encodeToJSON(Object object){
		if (object == null)
			return " ";
		
		ObjectMapper mapper = new ObjectMapper();
		//ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] jsonBytes = new byte[100];
		try {
			//mapper.writeValue(byteStream, object);
			jsonBytes = mapper.writeValueAsBytes(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String jsonData = byteStream.toString();
		String jsonData = new String(jsonBytes);
		return jsonData;
	}
	
	public static RegistrationData decodeRegistrationJSON(String jsonString){
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		RegistrationData registrationData = null;
		
		try {
			registrationData = mapper.readValue(jsonString, RegistrationData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationData; 

	}

	public static TaxData decodeTaxData(String jsonString){
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		TaxData taxData = null;
		
		try {
			taxData = mapper.readValue(jsonString, TaxData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taxData; 

	}

	public static UserSessionInfo decodeUserSessionJSON(String jsonString){
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		UserSessionInfo userSession = null;
		
		try {
			userSession = mapper.readValue(jsonString, UserSessionInfo.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userSession; 

	}
	
	public static UserDetails decodeUserDetailsJSON(String jsonString){
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		UserDetails userDetails = null;
		
		try {
			userDetails = mapper.readValue(jsonString, UserDetails.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails; 

	}
	
	public static PaymentData decodePaymentsJSON(String jsonString){
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		PaymentData payments = null;
		
		try {
			payments = mapper.readValue(jsonString, PaymentData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payments; 

	}


	public static ITRClassificationData decodeITRClassificationJSON(
			String jsonString) {
		
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		ITRClassificationData itrClassificationData = null;
		
		try {
			itrClassificationData = mapper.readValue(jsonString, ITRClassificationData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itrClassificationData; 
	}

	public static SalaryIncomeData decodeSalaryIncomeDataJSON(String jsonString) {
		
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		SalaryIncomeData salaryIncome = null;
		
		try {
			salaryIncome = mapper.readValue(jsonString, SalaryIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salaryIncome; 
	}

	public static RentalIncomeData decodeRentalIncomeDataJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		RentalIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, RentalIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static GiftIncomeData decodeGiftIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		GiftIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, GiftIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static InterestIncomeData decodeInterestIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		InterestIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, InterestIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static MachineryIncomeData decodeMachineryIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		MachineryIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, MachineryIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static DividendIncomeData decodeDividendIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		DividendIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, DividendIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static AgricultureIncomeData decodeAgricultureIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		AgricultureIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, AgricultureIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}
	
	public static TaxExemptMinorIncomeData decodeTaxExemptMinorIncomeJSON(String jsonString) {
		if (jsonString == null)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		TaxExemptMinorIncomeData dataObject = null;
		
		try {
			dataObject = mapper.readValue(jsonString, TaxExemptMinorIncomeData.class);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataObject; 
	}

	public static ExemptionsData decodeExemptionJSON(String jsonString) {
		if (jsonString == null)
			return null;

			ObjectMapper mapper = new ObjectMapper();
			ExemptionsData dataObject = null;
			
			try {
				dataObject = mapper.readValue(jsonString, ExemptionsData.class);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataObject; 	
	}

	public static ITRData decodeITRDataJSON(String jsonString) {
		if (jsonString == null)
			return null;

			ObjectMapper mapper = new ObjectMapper();
			ITRData dataObject = null;
			
			try {
				dataObject = mapper.readValue(jsonString, ITRData.class);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataObject; 	
	}
	
	public static AllData decodeAllDataJSON(String jsonString) {
		if (jsonString == null)
			return null;

			ObjectMapper mapper = new ObjectMapper();
			AllData dataObject = null;
			
			try {
				dataObject = mapper.readValue(jsonString, AllData.class);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataObject; 	
	}


}
