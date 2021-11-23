package by.guzypaul.medicinecentre.controller.command;

import by.guzypaul.medicinecentre.controller.command.impl.AddAppointmentCommand;

public enum CommandType {


    ADD_APPOINTMENT {
        {
            this.command = new AddAppointmentCommand();
        }
    };
//    ADD_DOCTOR_SCHEDULE {
//        {
//            this.command = new AddDoctorScheduleCommand();
//        }
//    },
//    ADD_PROCEDURE {
//        {
//            this.command = new AddProcedureCommand();
//        }
//    },
//
//    CANCEL_APPOINTMENT{
//        {
//            this.command = new CancelAppointmentCommand();
//        }
//    },
//    CHANGE_DOCTOR_SCHEDULE{
//        {
//            this.command=new ChangeDoctorScheduleCommand();
//        }
//    },
//
//    CHANGE_PROCEDURE{
//        {
//            this.command= new ChangeProcedureCommand();
//        }
//    },
//
//
//    CONFIRM_APPOINTMENT{
//        {
//            this.command = new ConfirmAppointmentCommand();
//        }
//    },
//
//    TO_CHANGE_APPOINTMENT {
//        {
//            this.command = new ToChangeAppointmentCommand();
//        }
//    },
//
//    FIND_ALL_SCHEDULES{
//        {
//            this.command=new FindAllSchedulesCommand();
//        }
//    },
//    FIND_ALL_USERS {
//        {
//            this.command = new FindAllUsersCommand();
//        }
//    },
//    FIND_ALL_PROCEDURES {
//        {
//            this.command = new FindAllProceduresCommand();
//        }
//    },
//
//    LOG_IN {
//        {
//            this.command = new LogInCommand();
//        }
//    },
//    LOG_OUT {
//        {
//            this.command = new LogOutCommand();
//        }
//    },
//
//    SET_LOCALE {
//        {
//            this.command = new SetLocaleCommand();
//        }
//    },
//    SIGN_UP {
//        {
//            this.command = new SignUpCommand();
//        }
//    },
//
//    TO_ADD_PROCEDURE{
//        {
//            this.command=new ToAddProcedureCommand();
//        }
//    },
//
//    TO_CHANGE_PROCEDURE{
//        {
//            this.command=new ToChangeProcedureCommand();
//        }
//    },
//    TO_CHANGE_SCHEDULE {
//        {
//            this.command= new ToChangeScheduleCommand();
//        }
//    },
//
//    TO_SIGN_IN {
//        {
//            this.command = new ToSignInCommand();
//        }
//    },
//    TO_SIGN_UP {
//        {
//            this.command = new ToSignUpCommand();
//        }
//    },
//
//    UNKNOWN_COMMAND {
//        {
//            this.command = new UnknownCommand();
//        }
//    },
//    UPDATE_APPOINTMENT{
//        {
//            this.command = new UpdateAppointmentCommand();
//        }
//    };

    Command command;

    /**
     * @return {@link Command}
     */
    public Command getCurrentCommand() {
        return command;
    }
}
