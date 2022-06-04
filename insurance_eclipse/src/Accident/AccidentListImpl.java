package Accident;

import java.util.List;
import Dao.AccidentDao;

public class AccidentListImpl implements AccidentList {
	private AccidentDao accidentDao = new AccidentDao();

	public AccidentListImpl() {
	}

	public List<Accident> getAccidentList() {
		List<Accident> accidentLists = accidentDao.getAccidentList();
		return accidentLists;
	}

	public boolean createAccident(Accident accident) {
		return accidentDao.addAccident(accident);
	}

	public boolean deleteAccident(Long accidentIdx) {
		return accidentDao.deleteAccident(accidentIdx);
	}

	@Override
	public boolean modifyCheckAccident(Long accidentIdx) {
		return accidentDao.modifyCheckAccident(accidentIdx);
	}
	@Override
	public boolean modifyCompensationPrice(Long accidentIdx, int price) {
		return accidentDao.modifyCompensationPrice(accidentIdx, price);
	}

}