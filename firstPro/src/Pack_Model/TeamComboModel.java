package Pack_Model;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import Pack_Team.TeamDAO;
import Pack_Team.TeamVO;

public class TeamComboModel extends DefaultComboBoxModel<Object> {
	ArrayList<TeamVO> teams = new ArrayList<TeamVO>();

	public TeamComboModel() {
		TeamDAO dao = new TeamDAO();
		teams = dao.selectTeam();
	}

	@Override
	public int getSize() {
		return teams.size();
	}

	@Override
	public Object getElementAt(int index) {
		String resultTeam = teams.get(index).getT_code() + "(" + teams.get(index).getT_name() + ")";
		return resultTeam;
	}
	
}