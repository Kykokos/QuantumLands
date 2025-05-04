This mod adds many fun and useful items. For your own Centrifuge Recipe you can make a datapack. 
**BUT BEWARE you have to remove the input item from the tag “forge:all_items” otherwise the recipe will not work.You can do this with KUBEJS or you can replace(delete) the tag completely and make your own recipe for essence.** Recipe json structure:
<pre>{
  "type": "quantum_lands:centrifuging",
  "ingredients": [
    {
      "item": "quantum_lands:blue_planks"
    }
  ],
  "output1": {
    "item": "minecraft:oak_planks"
  },
  //the second output is not required
  "output2": {
    "item": "quantum_lands:blue_substance"
  }
} </pre>

