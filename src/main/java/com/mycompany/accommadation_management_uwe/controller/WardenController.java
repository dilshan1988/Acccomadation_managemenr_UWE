package com.mycompany.accommadation_management_uwe.controller;

import com.mycompany.accommadation_management_uwe.pojo.Room;
import com.mycompany.accommadation_management_uwe.pojo.RoomCleanStatus;
import com.mycompany.accommadation_management_uwe.pojo.WorkOrder;
import java.util.List;

public class WardenController {

	public boolean setRoomCleanStatus(int hallNumber, int roomNumber, RoomCleanStatus roomCleanStatus) {
		return false;
	}

	public boolean generateWorkOrder(WorkOrder workOrder) {
		return false;
	}

	public List getListOfRooms(int hallNumber) {
		return null;
	}

	public List getListOfWorkOrders(int HallNumber) {
		return null;
	}

	public List getListOfReportedIssues(int hallNumber) {
		return null;
	}

	public Room getRoom(int hallNumber, int roomNumber) {
		return null;
	}

}
