package Pack_Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Pack_Player.PlayerDAO;
import Pack_Player.PlayerVO;

public class PlayerTableModel extends AbstractTableModel {
	private String[] columnNames = { "선수번호", "팀명", "선수명", "키", "생년월일", "몸무게", "포지션", "등번호" };
	private ArrayList<PlayerVO> players;

	public PlayerTableModel(String playerName) {
		PlayerDAO dao = new PlayerDAO();
		players = dao.searchPlayer(playerName);
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		return players.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String result = "";
		PlayerVO to = players.get(rowIndex);
		switch (columnIndex) {
			case 0:
				result = to.getP_no();
				break;
			case 1:
				result = to.getT_code();
				break;
			case 2:
				result = to.getP_name();
				break;
			case 3:
				result = to.getP_length();
				break;
			case 4:
				result = to.getP_birth();
				break;
			case 5:
				result = to.getP_weight();
				break;
			case 6:
				result = to.getP_pos();
				break;
			case 7:
				result = to.getP_backno();
				break;
		}

		return result;
	}
}