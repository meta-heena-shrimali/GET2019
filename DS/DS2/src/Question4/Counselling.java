package Question4;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;

public class Counselling {

    private Program programList[];
    private int size;
    private StudentAllocationList allocatedStudentsList[];
    private int size1 = 0;
    private Queue<StudentNode> queue;

    public void programs() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(
                    "src/Question4/Programs.xls"));
            Sheet sheet = workbook.getSheet(0);
            this.programList = new Program[sheet.getRows()];
            String programName = null;
            int capacity = 0;
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    // Obtain reference to the Cell using getCell(int col, int
                    // row)
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        programName = cell.getContents();
                    } else if (type == CellType.NUMBER) {
                        capacity = Integer.parseInt(cell.getContents());
                    }
                }
                Program p = new Program(programName, capacity);
                this.programList[i] = p;
            }
        } catch (BiffException e) {
            // excelFileNotFound excelFileTooBig expectedGlobals
            // passwordProtected
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void allocate() {
        this.allocatedStudentsList = new StudentAllocationList[size];
        int countAllocationList = 0;
        // iterate every student in queue
        while (!this.queue.isEmpty()) {
            StudentNode student = this.queue.remove();
            String preferences[] = student.getData();

            outerloop: for (int countPreferences = 0; countPreferences < preferences.length; countPreferences++) {
                for (int countProgramList = 0; countProgramList < this.programList.length; countProgramList++) {
                    String programName = this.programList[countProgramList]
                            .getName();
                    if (preferences[countPreferences]
                            .equalsIgnoreCase(programName)) {
                        int remaining = programList[countProgramList]
                                .getRemainig();
                        if (remaining > 0) {
                            String allocatedProgram = programName;
                            String name = student.getName();
                            StudentAllocationList st = new StudentAllocationList(
                                    name, allocatedProgram);
                            allocatedStudentsList[countAllocationList] = st;
                            countAllocationList++;
                            size1++;
                            programList[countProgramList]
                                    .setRemainig(remaining - 1);
                            break outerloop;
                        }
                    }
                }
            }
        }
    }

    public void updateExcel() throws IOException {

        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(
                    "src/Question4/allocationList.xls"));
            WritableSheet wSheet = workbook.createSheet("sheet1", 0);
            for (int i = 0; i < this.size1; i++) {
                String name = this.allocatedStudentsList[i].getName();
                // Label constructor(col , row, value)
                Label labTemp1 = new Label(0, i, name);
                wSheet.addCell(labTemp1);
                String program = this.allocatedStudentsList[i]
                        .getAllocatedProgram();
                Label labTemp2 = new Label(1, i, program);
                wSheet.addCell(labTemp2);
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void addStudents() {
        this.size = 0;
        queue = new LinkedList<StudentNode>();
        try {
            Workbook workbook = Workbook.getWorkbook(new File(
                    "src/Question4/Students.xls"));
            Sheet sheet = workbook.getSheet(0);
            this.size = sheet.getRows();
            for (int i = 0; i < this.size; i++) {
                // Obtain reference to the Cell using getCell(int col, int row)
                Cell name = sheet.getCell(0, i);
                String studentName = name.getContents();
                String[] pref = new String[5];
                for (int j = 1; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        pref[j - 1] = cell.getContents();
                    }
                }
                StudentNode student = new StudentNode(studentName, pref);
                queue.add(student);
            }
        } catch (BiffException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}