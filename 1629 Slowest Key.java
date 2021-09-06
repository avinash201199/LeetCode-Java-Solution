class Solution {
public char slowestKey(int[] releaseTimes, String keysPressed) {

    int maxTime = releaseTimes[0];
    int diffTime;
    
    char slowestKey = keysPressed.charAt(0);
    
    for(int i = 1; i < releaseTimes.length; i++){
        
        diffTime = releaseTimes[i] - releaseTimes[i - 1];
        
        if(diffTime > maxTime){
            maxTime = diffTime;
            slowestKey = keysPressed.charAt(i);
        }
        else if(diffTime == maxTime){
            if(keysPressed.charAt(i) > slowestKey){
                slowestKey = keysPressed.charAt(i);
            }
        }
    }
    
    
    return slowestKey;      
            
}
}
