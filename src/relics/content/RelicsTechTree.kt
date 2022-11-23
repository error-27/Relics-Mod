package relics.content

import arc.struct.Seq
import mindustry.content.Blocks
import mindustry.content.Items
import mindustry.content.TechTree
import mindustry.content.TechTree.TechNode
import mindustry.ctype.UnlockableContent
import mindustry.game.Objectives
import mindustry.type.ItemStack

class RelicsTechTree {
    companion object{
        public var context: TechNode? = null;
    }

    fun load() {
        createNode(Blocks.duo, ) { node(RelicsTurrets.solo) {node(RelicsTurrets.stream)} }
        createNode(Blocks.scorch) {node(RelicsTurrets.incinerate, Seq.with(Objectives.Produce(Items.pyratite)))}
        createNode(Blocks.scatter) {node(RelicsTurrets.fragment); node(RelicsTurrets.split)}
    }


    private fun createNode(parent: UnlockableContent, children: Runnable){
        val parentNode: TechNode = TechTree.all.find { it -> it.content == parent}
        context = parentNode
        children.run()
    }

    private fun node(content: UnlockableContent, requirements: Array<ItemStack>, objectives: Seq<Objectives.Objective>?, children: Runnable): TechNode{
        val node: TechNode = TechNode(context, content, requirements)
        if(objectives != null){
            node.objectives = objectives
        }
        val prev: TechNode? = context
        context = node
        children.run()
        context = prev

        return node
    }

    private fun node(content: UnlockableContent, requirements: Array<ItemStack>, children: Runnable): TechNode{
        return node(content, requirements, null, children)
    }

    private fun node(content: UnlockableContent, children: Runnable): TechNode{
        return node(content, content.researchRequirements(), children)
    }

    private fun node(content: UnlockableContent): TechNode{
        return node(content) {}
    }

    private fun node(content: UnlockableContent, objectives: Seq<Objectives.Objective>?) {
        node(content, content.researchRequirements(), objectives) {}
    }

    private fun nodeProduce(content: UnlockableContent, objectives: Seq<Objectives.Objective>?, children: Runnable): TechNode{
        return node(content, content.researchRequirements(), objectives?.add(Objectives.Produce(content)), children)
    }

    private fun nodeProduce(content: UnlockableContent, children: Runnable): TechNode{
        return nodeProduce(content, Seq(), children)
    }
}