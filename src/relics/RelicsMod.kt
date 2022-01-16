package relics

import arc.*
import arc.util.*
import mindustry.game.EventType.*
import mindustry.mod.*
import mindustry.ui.dialogs.*
import relics.content.*

class RelicsMod : Mod(){

    init{
        Log.info("Loaded Relics mod constructor.")
    }

    override fun loadContent(){
        Log.info("Loading Relics content.")
        RelicsBullets().load()
        RelicsTurrets().load()
        Log.info("Content loaded!")
    }
}
