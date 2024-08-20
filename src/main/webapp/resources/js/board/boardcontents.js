class UploadAdapter {
    constructor(loader) {
        this.loader = loader;
    }

    upload(){
        return this.loader.file.then(file => new Promise(((resolve, reject)=> {
            const files = new FormData();
            files.append("upload", file)
            fetch("./uploadContentImage", {
                method:"POST",
                
                body: files
            })
            .then(r=>r.json())
            .then(r=>{
            	
            	console.log(r.url);
                resolve({
                    default:r.url
                })
            })
            .catch(e=>{
                return reject(e) //reject('File upload Fail')
            })
        }))
    )}

}



function MyCustomUploadAdapterPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
        return new UploadAdapter(loader)
    }
}

 setMax(5);
        
        ClassicEditor.create( 
        		document.getElementById( 'editor' ), {
        			extraPlugins: [MyCustomUploadAdapterPlugin]
               }
        	   
             )
        	 .then(editor=>{
        		window.editor=editor
        	 })
        	 
        	 .catch(error=>{
        			console.log('error')
        	 });	