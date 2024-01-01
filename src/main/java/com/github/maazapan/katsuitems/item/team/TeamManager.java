package com.github.maazapan.katsuitems.item.team;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;

public class TeamManager {

    private Team team;

    public TeamManager() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        String teamName = "katsu-collision";
        team = scoreboard.getTeam(teamName);

        if (team == null) {
            team = scoreboard.registerNewTeam(teamName);
            team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
        }
    }

    /**
     * Join the team
     *
     * @param uuid Entity to join
     */
    public void joinTeam(UUID uuid) {
        team.addEntry(uuid.toString());
    }

    /**
     * Remove a player from the team
     *
     * @param uuid Entity to remove
     */
    public void removeTeam(UUID uuid) {
        team.removeEntry(uuid.toString());
    }

    /**
     * Check if a player is in a team
     *
     * @param uuid Entity to check
     */
    public boolean isTeamMember(UUID uuid) {
        return team.hasEntry(uuid.toString());
    }
}
