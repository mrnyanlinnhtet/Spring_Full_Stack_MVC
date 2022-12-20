window.addEventListener('load',()=>{
	
	 console.log('JavaScript is Starting ... !');
	 
	let requestBtn =  document.getElementById('reqBtn');
	let sseBtn = document.getElementById('sseTrigger');
	 const output  = document.getElementById('output');
	
	requestBtn.addEventListener('click',async()=>{
		
		  console.log('Request is sending .... ');
		  
		 
		  const response =  await fetch("http://localhost:8080/stream");
		  const reader = response.body.pipeThrough(new TextDecoderStream() ).getReader();
		  
		  while(true){
			const{value,done} = await reader.read();
			
			if(done){
				break;
			}
			
			let createList = document.createElement('li');
			createList.innerText = value;
			
			output.appendChild(createList);
			
		}
		  
		  
	});
	
	sseBtn.addEventListener('click',()=>{
		
		 console.log('Sse Result is Starting ....');
		 
		 var eventSource = new EventSource('http://localhost:8080/sse');
		  eventSource.onmessage = message=>{
			let createList = document.createElement('li');
		     createList.innerText = message.data;
		     output.appendChild(createList);
		}
		
		eventSource.onerror = ()=>{
			 eventSource.close();
		}
	})
	
	
});