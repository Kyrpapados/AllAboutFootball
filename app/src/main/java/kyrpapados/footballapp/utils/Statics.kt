package kyrpapados.footballapp.utils

class Statics {
    companion object {
        val BASE_URL : String = "http://api.football-data.org/v2/"
        val AUTH_TOKEN : String = "0b83071c8818431cbed380285124c798"

        /**
         * Preferences
         **/
        val PREFERENCES = "FOOTBALL_PREFERENCES"
        val FIRST_INSTALL = "FIRST_INSTALL"
        val BALL_DIMENS = "BALL_DIMENS"
        val TEXT_DIMENS = "TEXT_DIMENS"
        val SCREEN_WIDTH = "SCREEN_WIDTH"

        //LABELS
        val X_AUTH_TOKEN : String = "X-Auth-Token"
        val COMPETITION : String = "COMPETITION"
        val COMPETITION_ID : String = "COMPETITION_ID"
        val CURRENT_MATCHDAY : String = "CURRENT_MATCHDAY"

        val TIER_ONE : String = "TIER_ONE"
        val AREAS_IDS : String = "2072,2077,2081,2088,2114,2224"
        //val AREAS_IDS : String = "2072,2081,2114,2088,2224"
        val PREMIER_LEAGUE : String = "Premier League"
        val CHAMPIONS_LEAGUE : String = "UEFA Champions League"
        val BUNDESLIGA : String = "Bundesliga"
        val SERIE_A : String = "Serie A"
        val PRIMERA_DIVISION : String = "Primera Division"
        val LIGUE_1 : String = "Ligue 1"

        val TOTAL_TYPE: String = "TOTAL"
        val TEAM_ID: String = "TEAM_ID"
        val HOME_TYPE: String = "HOME"
        val AWAY_TYPE: String = "AWAY"

        val VIEW_TITLE: Int = 1
        val VIEW_ITEM: Int = 2

        val ROLE_PLAYER: String = "PLAYER"
        val ROLE_COACH: String = "COACH"

        val POSITION_GOALKEEPER: String = "Goalkeeper"
        val POSITION_DEFENDER: String = "Defender"
        val POSITION_MIDFIELDER: String = "Midfielder"
        val POSITION_ATTACKER: String = "Attacker"

    }
}