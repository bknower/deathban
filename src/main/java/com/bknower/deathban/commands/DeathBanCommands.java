package com.bknower.deathban.commands;

import com.bknower.deathban.DeathBan;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class DeathBanCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdDeathban = dispatcher.register(
                Commands.literal(DeathBan.MODID)
                        .then(CommandTest.register(dispatcher))
        );

        dispatcher.register(Commands.literal("deathban").redirect(cmdDeathban));
    }
}
