class GroovyCronSchedule {

	List cronDays = (0..6)
	List cronHours =(0..24)
	List cronMins =(0..60)
	List cronSecs =(0..60)
	List cronMillis =(0..999)

	void setCronByProperties(String propertiesFilename){
		def props = propertiesFilename

		Properties properties
		properties = new Properties()
		File propertiesFile
		propertiesFile = new File(props)

		if (propertiesFile.exists()){
		    propertiesFile.withInputStream{
		        properties.load(it)
		        }
		    }
		else{
		    println "No connection.properties File Present in lib folder"
		    println System.getProperty("user.dir")
		    return //1
		}
		if(properties.days){this.cronDays = Eval.me(properties.days)}
		if(properties.hours){this.cronHours = Eval.me(properties.hours)}
		if(properties.mins){this.cronMins = Eval.me(properties.mins)}
		if(properties.secs){this.cronSecs = Eval.me(properties.secs)}
		if(properties.millis){this.cronMillis = Eval.me(properties.millis)}
	}

	def checkSchedule(){

		def timestamp = new Date().format("yyyy-MM-dd HH:mm:ss,SSS")
		def nowDays = new Date().format("u").toInteger()
		def nowHours = new Date().format("HH").toInteger()
		def nowMins = new Date().format("mm").toInteger()
		def nowSecs = new Date().format("ss").toInteger()
		def nowMillis = new Date().format("SS").toInteger()
		
		boolean flag = true
		if (!cronHours.any{it == nowHours}){
			flag = false
		}
		if (!cronMins.any{it == nowMins}){
			flag = false
		}
		if (!cronDays.any{it == nowDays}){
			flag = false
		}
		if (!cronSecs.any{it == nowSecs}){
			flag = false
		}
		if (!cronMillis.any{it == nowMillis}){
			flag = false
		}
		return flag
	}
}
static void main(String[] args) {
	def sched = new GroovyCronSchedule()
	sched.setCronByProperties("lib\\"+args[0])
	if(sched.checkSchedule()){
		//println("Cron correct")
		evaluate(new File(args[1]))
	}
	else{
		//println("Cron not correct")
	}
}