

public class MelodyQueue {
	

   private Node front;
   private Node back;

   public MelodyQueue(){
      front = null;
      back = null;
   }
   
   public void enqueue(Object item){
      Node nodeItem = new Node(item);
      
      if(front == null){
         front = nodeItem;
         back = front;
      }
      else{
         back.setNext(nodeItem);
         back = back.getNext();
      }
   }
   
   public void dequeue(){
      if(front == null){
         System.out.println("Queue is Empty.");
      }
      else{
         front = front.getNext();
      }   
   }
   
   public boolean isEmpty(){
      if(front == null && back == null){
         return true;
      }
      else{
         return false;
      }
   }
   
   public double duration(){
      double seconds = 0.0;
      Node b = front;
      while(b != null){
         seconds = seconds + ((Note) b.getItem()).getDuration();
         b = b.getNext();
      }
      return seconds + timeRepeat();
   }
   
   public double timeRepeat(){
      double duration = 0.0;
      boolean isRepeated;
      Node a = front;
      while(a != null){
         isRepeated = ((Note) a.getItem()).isRepeat();
         if(isRepeated){
            duration = duration + ((Note) a.getItem()).getDuration();
            a = a.getNext();
            isRepeated = ((Note) a.getItem()).isRepeat();
            while(!isRepeated){
               duration = duration + ((Note) a.getItem()).getDuration();
               a = a.getNext();
               isRepeated = ((Note) a.getItem()).isRepeat();
            }
            duration = duration + ((Note) a.getItem()).getDuration();
            a = a.getNext();
         }
         else{
            a = a.getNext();
         }
      }
      return duration;    
   }
   
   public int size(){
      Node current = front;
      int size = 0;
      while(current != null){
         size++;
         current = current.getNext();
      }
      return size;
   }
   
   public String makeString(){
      String string = "";
      Node current = front;
      while(current != null){
         string = string + ((Note) current.getItem()).toString() + "\n";
         current=current.getNext();
      }
      return string;
   }
   
   public void tempoChange(double tempo){
      Node c = front;
      while(c != null){
         Note n1 = ((Note) c.getItem());
         n1.setDuration(n1.getDuration()/tempo);
         c = c.getNext();
      }
   }
   
   public void playRepeat(){
      Node curr = front;
      while(curr != null){
         Note n2 = ((Note) curr.getItem());
         n2.play();
         curr = curr.getNext();
      }
   }
   
   public void appendMelody(MelodyQueue other){
      Node o = other.front;
      while(!o.equals(other.back)){
         back.setNext(o);
         back = back.getNext();
         o = o.getNext();
      }
      back.setNext(o);
      back = back.getNext();
      //this.back.setNext(other.front);
      //this.back = back.getNext();
   }
   
   public MelodyQueue reverseMelody(){
      Node q1 = front;
      MelodyQueue q2 = new MelodyQueue();
      NoteStack stack = new NoteStack();
      while(q1 != null){
         stack.push(q1.getItem());
         q1 = q1.getNext();
      }
      q1 = stack.top;
      while(q1 != null){
         q2.enqueue(stack.pop());
         q1 = stack.top;
      }      
      return q2;   
   }
   
   public void play(){
      Node d = front;
      boolean isRepeated;
      MelodyQueue temp = new MelodyQueue();
      while(d != null){
         Note n3 = ((Note) d.getItem());
         isRepeated = n3.isRepeat();
         if(isRepeated){
            temp.enqueue(n3);
            n3.play();
            d = d.getNext();
            n3 = ((Note) d.getItem());
            isRepeated = n3.isRepeat();
            while(!isRepeated){
               temp.enqueue(n3);
               n3.play();
               d = d.getNext();
               n3 = ((Note) d.getItem());
               isRepeated = n3.isRepeat();
            }
            temp.enqueue(n3);
            n3.play();
            temp.playRepeat();
            d = d.getNext();
         }
         else{
            n3.play();
            d = d.getNext();
         }
      }
   }
}
