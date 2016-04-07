node {
   for (int i=0; i<2; ++i) {
     stage "Stage #"+i
     print 'Hello, World $i!'
   }
  
   stage "Stage Parallel"
   def branches = [:]
   for (int i=0; i<numHelloMessages.toInteger(); i++) {
      branches["split${i}"] = {
         stage "Stage Parallel- #"+i
	 node('remote') {
   	  echo 'Starting sleep'
	  sleep 10
   	  echo 'Finished sleep'
 	  }
      }
   }
}
