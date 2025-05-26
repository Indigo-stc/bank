import { Icon } from "./icon";
import { Question } from "./question";
import { User } from "./user";

export class AnswerUser {
  id?: number;
  question?: Question;
  answer?: string;
  user?: User;
}

export class IconUser {
  id?: number;
  icon?: Icon;
  user?: User;
}