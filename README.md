This mod adds many fun and useful items. For your own Centrifuge Recipe you can make a datapack. Recipe json structure:
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

If you use this mod in your modpack add to Kube Js server scripts something like: adding_all_items_to_tag.js 
                             And insert there:
<pre>
ServerEvents.tags('item', event => {
    const allItems = Ingredient.all.itemIds
    allItems.forEach(id => {
      if (!id.includes('air')) {
        event.add('forge:all_items', id)
      }
    })
})  </pre>

But don't forget that if you have any custom craftings you have to untag the ingredient items from the "forge:all_items" tag.
You do this by adding to adding_all_items_to_tag.js something like: 
<pre>
    event.remove('forge:all_items', 'quantum_lands:blue_planks')</pre>
