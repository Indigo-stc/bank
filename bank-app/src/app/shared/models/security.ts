import { Icon } from "./icon";
import { Question } from "./question";
import { User } from "./user";

export class Security {
  id?: number;
  user?: User;
  question?: Question;
  icon?: Icon;
  answer?: string;
}