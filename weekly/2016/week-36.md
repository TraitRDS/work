#### 2016-9-9
1. CF for AS
  - AEPeerRuntimeSupportImpl.java  
    `uploadInputContainers` will upload all containers if the `ExtensionObjectPeer` is not implement the `AslGenerationProvider` interface. Otherwise it will call the `preAslGeneration` method to upload the containers.
  - R on Remote AS  
    rporcess and rapplier ASL created by CF don't handle the output container.
2. Algorithms playback  
  [Playback record](https://ibm.ent.box.com/s/ol1q55by7r0wyl3jap3exsfj2d435raj/1/11213020603)  
  New spark algorithms has supported Scala API, and will support Python API, R API is TBP.  
  Algorithms can run on the DSX.  
    
