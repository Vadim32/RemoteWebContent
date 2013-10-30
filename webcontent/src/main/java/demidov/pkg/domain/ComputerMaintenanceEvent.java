package demidov.pkg.domain;


public class ComputerMaintenanceEvent extends UserEvents {

	
	
	private String descriptionMaintenance;
	
		public String getDescriptionMaintenance() {
			return descriptionMaintenance;
		}
	
		public void setDescriptionMaintenance(String descriptionMaintenance) {
			this.descriptionMaintenance = descriptionMaintenance;
		}
		
	
			
	private String additionalInfoMaintenance;

		public String getAdditionalInfoMaintenance() {
			return additionalInfoMaintenance;
		}
	
		public void setAdditionalInfoMaintenance(String additionalInfoMaintenance) {
			this.additionalInfoMaintenance = additionalInfoMaintenance;
		}
		
				
}